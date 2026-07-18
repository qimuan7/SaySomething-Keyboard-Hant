package com.brycewg.asrkb.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.brycewg.asrkb.ui.settings.compose.components.MarkdownViewer
import com.brycewg.asrkb.ui.settings.compose.core.BibiSettingsTheme
import com.brycewg.asrkb.ui.settings.compose.core.BibiUiMode

class MarkdownViewerActivity : BaseActivity() {
    companion object {
        const val EXTRA_ASSET_PATH = "extra_asset_path"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val assetPath = intent.getStringExtra(EXTRA_ASSET_PATH) ?: return finish()

        val markdown = try {
            assets.open(assetPath).bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            "Failed to load markdown: ${e.message}"
        }

        setContent {
            BibiSettingsTheme(uiMode = BibiUiMode.Material, themeMode = "system") {
                Scaffold { padding ->
                    MarkdownViewer(markdown = markdown, modifier = Modifier.fillMaxSize().padding(padding))
                }
            }
        }
    }
}
