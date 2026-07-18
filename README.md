# 語音輸入 - 偏執的離線語音輸入體驗

使用離線 AI 模型的語音輸入法

基於 [說點啥(Saysomething)](https://github.com/BryceWG/BiBi-Keyboard) 輸入法

使用 [OpenCC](https://github.com/qichuan/android-opencc) 提供繁體中文輸入

移除在線功能, 還你一個即使沒有互聯網也依然可靠的語音輸入方式

---

## Multi Languages Introduction :

繁體中文 : 往下滑 >.>)

简体中文 : [打开](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/1/projects-readme-and-assets_br1/README_ZH-Hans.md)

English : [Open](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/1/projects-readme-and-assets_br1/README_EN.md)

日本語 : [開ける](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/1/projects-readme-and-assets_br1/README_JA.md)

---

### Original Project's Introduction:

原项目介绍 (简体中文) : [打开: 简体中文](https://github.com/BryceWG/BiBi-Keyboard/blob/main/README.md)

Original Project's Introduction (English) : [Open: English](https://github.com/BryceWG/BiBi-Keyboard/blob/main/README_EN.md)

---


## 功能:


### 語音辨識:

- 可識別語言涵蓋 普通話, 粵語, 地方語言, 英文, 日文, 及更多

- 完全離線的語音識別模型, 從 100MB 到 800MB, 快速, 準確, 穩定, 保護私隱
   

### 輸入與界面:

- AI編輯面板, 只需語音指令即可編輯文字

- 可自訂按鍵佈局

- Material-3 和 MiuiX 界面風格

- 多語言顯示: 簡體中文、繁體中文、英文、日語

- 極簡初始設定


### 更多功能: 我只當做普通語音輸入法用, 部分功能可以等你去發現~
   

### 界面展示(平板端):

- **界面展示(中文):**  https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/1/projects-readme-and-assets_br1/assets/ui-1-zh.mp4

- **輸入展示(三語):**  https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/1/projects-readme-and-assets_br1/assets/type-en-md-ct.mp4
---

## 使用:

### 系統:

- Android 8.0 (API 26) 或更高版本

### 權限:
  
- 麥克風權限（必須，用於語音辨識）

- 懸浮窗權限（可選，用於懸浮球功能）
  
- 無障礙權限（可選，用於自動插入文字）
  
### 安裝 & 啟用:
  
1. 從 [Releases](https://github.com/qimuan7/SaySomething-Keyboard-Hant/releases) 頁面下載 "Spime_**BR1**_vXXX(XXX).apk" 版本 APK
  
2. 安裝到 Android 設備

3. 根據初始畫面獲取權限: 設定 → 系統 → 語言與輸入法 → 虛擬鍵盤 → 管理鍵盤 → 啟用"「語音輸入」"

### 下載模型:

1. 打開設定
  
2. 選擇喜歡的語音辨識服務商, 選擇模型大小並點擊一鍵下載
  
- 若想要手動下載, 前往設定-語音辨識設定-去查看配置教學, 即可喚起內嵌的離線配置指導頁面, 你可以在其中找到模型下載連結, 或在 [Release-ModelDownload]() 中下載保存
  
### 使用~

- 在任意輸入框切換說點啥輸入法, 並長按麥克風按鈕即可開始辨識

---

## 原版, 分支2, 以及該版本的區別 (二改內容):

### [原版](https://github.com/BryceWG/BiBi-Keyboard)

- 擁有一切基礎功能

- 擁有原版應用更新

- 沒有繁體中文輸入

- 附帶在線服務與可選的數據收集

### [分支2 (此倉庫另一分支)](https://github.com/qimuan7/SaySomething-Keyboard-Hant/tree/2)

- 相比較原版, **擁有同樣的全部功能 & 內容**

- **額外添加繁體中文輸入**

- **沒有(檢查)更新**

- **可以與原版共存, 不能與分支1共存**

### [分支1 (此分支)](https://github.com/qimuan7/SaySomething-Keyboard-Hant/)

- 相比較原版, **除保留模型下載功能, 移除所有在線功能** (WebDAV備份, 匿名資料收集, 剪貼簿同步, 更新與檢查更新, Pro版本宣傳, ...)

- **隱藏所有在線AI服務商** (改爲默認使用離線模型, 內嵌原在線配置教學文檔)

- 替換原項目名稱, **中文** 改爲 **空白** 或 **"語音輸入"** ; **英文** 改爲 **空白** 或 **"Speech Input"**

- **額外添加繁體中文輸入**

- **可以與原版共存, 不能與分支2共存**

---

## 注意:

如名稱所言, 這一分支將所有在線功能移除, 並去除原版名稱, 它是 "偏執的個人習慣" 下的產物, 並不適用於每個人

我編譯最初只是爲了給自己用, 所以做了許多看起來奇怪且非必要的更改.

移除在線功能是因爲我對在線的不信任, 擔心身處於斷網的位置時手機的所有功能都會無法使用, 所以這只是一次普通的替代.

移除原項目名字並非想要偷取或另立門戶, 只是 "BIBI" 這個詞勾起我的陰影, 所以我在此分支將其移除

如果你想要原版的體驗, 奈何沒有繁體輸入, 你可以嘗試使用分支2, 那是純粹的原版+繁體輸出

## 警告:

此項目的更改 99.9% 都由 Gemini AI Agent 3.1 編寫, 而作者(我)是一個幾乎不懂代碼的普通人類...

剩下 0.1% 是我爲了避被原版覆蓋更新而手動改的包名, 版本號, 和 權限識別碼.

所以遇到問題是很正常的~~ 儘管我也不知道怎麼修 (對手指

***請不要在沒有確定問題是哪來的以前, 把使用這個項目遇到的 bug 丟到原項目 issus, 這會對彼此造成巨大的困擾 !!! 非常感謝 !!!***


## 所屬聲明:

**此項目使用語音輸入法 github.com/BryceWG/BiBi-Keyboard 的 4.1.2 版本二改,**

**使用 github.com/qichuan/android-opencc 的 OpenCC 庫 (S2T, S2HK, S2TWP) 實現繁體中文輸出**

講實話我沒有用過原項目的Pro版, 也不知道其中的"繁體中文輸出"如何實現

我的目標不是取代或者破譯原項目的Pro版本 (也做不到),

但我作爲慣用繁體字的用戶, 希望喜歡的鍵盤項目可以被更方便的日用, 而不需要另外轉換文字

所以我創建了這個分支, 只是它剛好也在原項目的Pro版的功能清單裏

我也相信原項目的Pro版 (或許) 基於AI輸出, 會有比我用 OpenCC 強行转换有更好的輸出效果

如果你喜歡這個輸入法, 請多多給予原項目一點支援和鼓勵吧 (〃￣︶￣)人(￣︶￣〃) 這麼好的項目只有 706 star 真的很難過好嘛

---

願你今日快樂ouo. --qimuan7

---
