package com.brycewg.asrkb.ime

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.FileProvider
import com.brycewg.asrkb.R
import com.brycewg.asrkb.clipboard.ClipboardHistoryStore
import com.brycewg.asrkb.clipboard.EntryType
// 移除 SyncClipboardManager 引用
import com.brycewg.asrkb.store.Prefs
import java.io.File
import java.security.MessageDigest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

internal class ImeClipboardCoordinator(
    private val context: Context,
    private val prefs: Prefs,
    private val serviceScope: CoroutineScope,
    private val rootViewProvider: () -> android.view.View?,
    private val actionHandler: KeyboardActionHandler,
    private val isClipboardPanelVisible: () -> Boolean,
    private val refreshClipboardPanelList: () -> Unit,
    private val clipStoreProvider: () -> ClipboardHistoryStore?,
    private val showStatusMessage: (String) -> Unit
) {
    private var clipboardManager: ClipboardManager? = null
    private var clipboardChangeListener: ClipboardManager.OnPrimaryClipChangedListener? = null

    @Volatile private var lastShownClipboardHash: String? = null
    private val clipboardWorkMutex = Mutex()

// 移除 syncClipboardManager 引用

    fun startClipboardSync() {
        // 同步剪贴板功能已移除
    }

    fun stopClipboardSyncSafely() {
        // 同步剪贴板功能已移除
    }

    fun downloadClipboardFile(entry: ClipboardHistoryStore.Entry) {
        // 同步剪贴板功能已移除
    }

    fun downloadClipboardFileById(entryId: String) {
        val store = clipStoreProvider() ?: return
        val entry = store.getEntryById(entryId) ?: return
        downloadClipboardFile(entry)
    }

    fun openFile(filePath: String) {
        try {
            val file = File(filePath)
            if (!file.exists()) {
                Toast.makeText(
                    context,
                    context.getString(R.string.clip_file_not_found),
                    Toast.LENGTH_SHORT
                ).show()
                return
            }

            val uri = FileProvider.getUriForFile(
                context,
                "${context.packageName}.fileprovider",
                file
            )

            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, getMimeType(file))
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }

            try {
                context.startActivity(intent)
            } catch (e: android.content.ActivityNotFoundException) {
                // 如果没有应用可以打开，则使用系统分享
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = getMimeType(file)
                    putExtra(Intent.EXTRA_STREAM, uri)
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                context.startActivity(
                    Intent.createChooser(
                        shareIntent,
                        context.getString(R.string.clip_file_open_chooser_title)
                    ).apply {
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }
                )
            }
        } catch (e: Exception) {
            android.util.Log.e("AsrKeyboardService", "Failed to open file: $filePath", e)
            Toast.makeText(
                context,
                context.getString(R.string.clip_file_open_failed, e.message ?: ""),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun startClipboardPreviewListener() {
        if (clipboardManager == null) {
            clipboardManager =
                context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        }
        if (clipboardChangeListener == null) {
            clipboardChangeListener = ClipboardManager.OnPrimaryClipChangedListener {
                val clipSnapshot = clipboardManager?.primaryClip
                    ?: return@OnPrimaryClipChangedListener
                serviceScope.launch(Dispatchers.Default) {
                    val text = clipboardWorkMutex.withLock {
                        val currentText = readClipboardText(clipSnapshot) ?: return@withLock null
                        val h = sha256Hex(currentText)
                        if (h == lastShownClipboardHash) return@withLock null
                        lastShownClipboardHash = h
                        clipStoreProvider()?.addFromClipboard(currentText)
                        currentText
                    } ?: return@launch
                    withContext(Dispatchers.Main) {
                        if (isClipboardPanelVisible()) refreshClipboardPanelList()
                        actionHandler.showClipboardPreview(text)
                    }
                }
            }
        }
        clipboardManager?.addPrimaryClipChangedListener(clipboardChangeListener!!)
    }

    fun stopClipboardPreviewListener() {
        clipboardManager?.removePrimaryClipChangedListener(clipboardChangeListener)
    }

    fun markShownText(text: String) {
        lastShownClipboardHash = sha256Hex(text)
    }

    fun copyPlainTextToSystemClipboard(label: String, text: String): Boolean = try {
        val cm = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        cm.setPrimaryClip(ClipData.newPlainText(label, text))
        true
    } catch (e: Exception) {
        android.util.Log.e("AsrKeyboardService", "Failed to copy text to clipboard", e)
        false
    }

    private fun readClipboardText(clip: ClipData): String? {
        if (clip.itemCount <= 0) return null
        val item = clip.getItemAt(0)
        return item.coerceToText(context)?.toString()?.takeIf { it.isNotEmpty() }
    }

    private fun sha256Hex(s: String): String = try {
        val md = MessageDigest.getInstance("SHA-256")
        val bytes = md.digest(s.toByteArray(Charsets.UTF_8))
        val sb = StringBuilder(bytes.size * 2)
        for (b in bytes) sb.append(String.format("%02x", b))
        sb.toString()
    } catch (t: Throwable) {
        android.util.Log.w("AsrKeyboardService", "sha256 failed", t)
        s // fallback: use raw text as hash key
    }

    private fun getMimeType(file: File): String {
        val extension = file.extension.lowercase()
        return when (extension) {
            "jpg", "jpeg" -> "image/jpeg"
            "png" -> "image/png"
            "gif" -> "image/gif"
            "webp" -> "image/webp"
            "pdf" -> "application/pdf"
            "txt" -> "text/plain"
            "doc", "docx" -> "application/msword"
            "xls", "xlsx" -> "application/vnd.ms-excel"
            "ppt", "pptx" -> "application/vnd.ms-powerpoint"
            "zip" -> "application/zip"
            "mp4" -> "video/mp4"
            "mp3" -> "audio/mpeg"
            else -> "*/*"
        }
    }
}
