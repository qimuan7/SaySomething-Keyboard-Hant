/**
 * Compose 备份与同步设置页。
 *
 * 归属模块：ui/settings/compose/screens
 */
@file:Suppress("FunctionName")

package com.brycewg.asrkb.ui.settings.compose.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.Upload
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.brycewg.asrkb.R
import com.brycewg.asrkb.ime.AsrKeyboardService
import com.brycewg.asrkb.store.Prefs
import com.brycewg.asrkb.ui.settings.compose.components.SettingsLazyColumn
import com.brycewg.asrkb.ui.settings.compose.components.SettingsMessageDialog
import com.brycewg.asrkb.ui.settings.compose.components.SettingsMessageDialogState
import com.brycewg.asrkb.ui.settings.compose.core.BibiUiMode
import com.brycewg.asrkb.ui.settings.compose.core.SettingsActionController
import com.brycewg.asrkb.ui.settings.compose.core.SettingsLayoutMetrics
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val TAG = "BackupSettingsScreen"

@Composable
fun BackupSettingsScreen(
    uiMode: BibiUiMode,
    onBack: () -> Unit,
    actions: SettingsActionController
) {
    val context = androidx.compose.ui.platform.LocalContext.current
    val prefs = remember(context) { Prefs(context) }
    val scope = rememberCoroutineScope()

    var busyAction by remember { mutableStateOf<BackupBusyAction?>(null) }
    var messageDialog by remember { mutableStateOf<SettingsMessageDialogState?>(null) }

    fun showBackupMessage(message: String) {
        messageDialog = SettingsMessageDialogState(
            title = context.getString(R.string.title_backup_settings),
            message = message,
            confirmText = context.getString(android.R.string.ok)
        )
    }

    val exportLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument("application/json")
    ) { uri: Uri? ->
        if (uri != null) {
            scope.launch {
                busyAction = BackupBusyAction.FileExport
                showBackupMessage(exportSettings(context, prefs, uri).message)
                busyAction = null
            }
        }
    }
    val importLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        if (uri != null) {
            scope.launch {
                busyAction = BackupBusyAction.FileImport
                val result = importSettings(context, prefs, uri)
                showBackupMessage(result.message)
                busyAction = null
            }
        }
    }

    BackupScaffold(uiMode = uiMode, onBack = onBack) { innerPadding, scrollModifier ->
        SettingsMessageDialog(
            state = messageDialog,
            uiMode = uiMode,
            onDismiss = { messageDialog = null }
        )
        SettingsLazyColumn(
            uiMode = uiMode,
            modifier = Modifier.fillMaxSize(),
            miuixScrollModifier = scrollModifier,
            contentPadding = SettingsLayoutMetrics.pageContentPadding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(SettingsLayoutMetrics.SectionSpacing)
        ) {
            item("file") {
                BackupSection(uiMode = uiMode, titleRes = R.string.section_file_backup) {
                    BackupActionPreference(
                        id = "backup_export_file",
                        titleRes = R.string.btn_export_to_file,
                        icon = Icons.Rounded.Upload,
                        enabled = busyAction == null,
                        index = 0,
                        count = 2,
                        onClick = {
                            exportLauncher.launch(buildBackupFileName())
                        }
                    )
                    BackupActionPreference(
                        id = "backup_import_file",
                        titleRes = R.string.btn_import_from_file,
                        icon = Icons.Rounded.Download,
                        enabled = busyAction == null,
                        index = 1,
                        count = 2,
                        onClick = {
                            importLauncher.launch(arrayOf("application/json", "text/plain"))
                        }
                    )
                }
            }
        }
    }
}

private enum class BackupBusyAction {
    FileExport,
    FileImport
}

private data class BackupOperationResult(
    val success: Boolean,
    val message: String
)

private fun buildBackupFileName(): String = "asr_keyboard_settings_" +
    SimpleDateFormat("yyyyMMdd_HHmm", Locale.getDefault()).format(Date()) +
    ".json"

private suspend fun exportSettings(
    context: Context,
    prefs: Prefs,
    uri: Uri
): BackupOperationResult {
    val exported = withContext(Dispatchers.IO) {
        runCatching {
            context.contentResolver.openOutputStream(uri)?.use { os ->
                val jsonString = prefs.exportJsonString()
                os.write(jsonString.toByteArray(Charsets.UTF_8))
                os.flush()
            } ?: error("Output stream is null")
        }
    }
    return if (exported.isSuccess) {
        val name = uri.lastPathSegment ?: "settings.json"
        Log.d(TAG, "Settings exported successfully to $uri")
        BackupOperationResult(
            success = true,
            message = context.getString(R.string.toast_export_success, name)
        )
    } else {
        Log.e(TAG, "Failed to export settings", exported.exceptionOrNull())
        BackupOperationResult(
            success = false,
            message = context.getString(R.string.toast_export_failed)
        )
    }
}

private suspend fun importSettings(
    context: Context,
    prefs: Prefs,
    uri: Uri
): BackupOperationResult {
    val imported = withContext(Dispatchers.IO) {
        runCatching {
            val json = context.contentResolver.openInputStream(uri)
                ?.bufferedReader(Charsets.UTF_8)
                ?.use { it.readText() }
                ?: ""
            prefs.importJsonString(json)
        }
    }
    return if (imported.getOrDefault(false)) {
        context.refreshImeUi()
        Log.d(TAG, "Settings imported successfully from $uri")
        BackupOperationResult(
            success = true,
            message = context.getString(R.string.toast_import_success)
        )
    } else {
        imported.exceptionOrNull()?.let { Log.e(TAG, "Failed to import settings", it) }
        BackupOperationResult(
            success = false,
            message = context.getString(R.string.toast_import_failed)
        )
    }
}

private fun Context.refreshImeUi() {
    try {
        sendBroadcast(Intent(AsrKeyboardService.ACTION_REFRESH_IME_UI))
    } catch (e: Exception) {
        Log.e(TAG, "Failed to send refresh broadcast", e)
    }
}
