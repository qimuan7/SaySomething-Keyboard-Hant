package com.brycewg.asrkb.util

import android.content.Context
import com.brycewg.asrkb.store.Prefs
import com.zqc.opencc.android.lib.ConversionType
import com.zqc.opencc.android.lib.ChineseConverter as OpenCC

/**
 * 繁体中文转换工具类，封装 OpenCC。
 */
object ChineseConverter {
    /**
     * 将输入文本根据用户偏好转换为繁体中文。
     * 如果未开启转换，则返回原文本。
     */
    fun convert(context: Context, text: String, prefs: Prefs): String {
        if (!prefs.useTraditionalChinese || text.isEmpty()) {
            return text
        }
        
        return try {
            val config = prefs.openccConfig
            val type = when (config) {
                "s2hk.json" -> ConversionType.S2HK
                "s2twp.json" -> ConversionType.S2TWP
                else -> ConversionType.S2T
            }
            OpenCC.convert(text, type, context)
        } catch (e: Exception) {
            // 如果转换失败（例如配置加载问题），则回退到原文本
            text
        }
    }
}
