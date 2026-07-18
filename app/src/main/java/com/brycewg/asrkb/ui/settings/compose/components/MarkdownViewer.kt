package com.brycewg.asrkb.ui.settings.compose.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import android.widget.TextView
import io.noties.markwon.Markwon

@Composable
fun MarkdownViewer(markdown: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val markwon = remember { Markwon.create(context) }
    
    AndroidView(
        modifier = modifier.fillMaxSize().padding(16.dp).verticalScroll(rememberScrollState()),
        factory = { ctx ->
            TextView(ctx)
        },
        update = { textView ->
            markwon.setMarkdown(textView, markdown)
        }
    )
}
