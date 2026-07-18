# 說點啥 - 語音輸入法



基於 AI 在線服務或本地模型的智慧語音輸入法

讓你的語音輸入體驗更自然, 更高效

添加繁體中文輸出, 可以適用需要輸出繁體中文的用戶 (Ou<)



---

**如果你想要更簡潔的版本, 請查看主分支: [打開](https://github.com/qimuan7/SaySomething-Keyboard-Hant)**

---

## Multi Languages Introduction :

繁體中文 : 往下滑就有 >.>)

简体中文 : [打开](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/README_ZH-Hans.md)

English : [Open](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/README_EN.md)

日本語 : [開ける](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/README_JA.md)



### Original Project's Introduction:

原项目介绍 (简体中文) : [打开: 简体中文](https://github.com/BryceWG/BiBi-Keyboard/blob/main/README.md)

Original Project's Introduction (English) : [Open: English](https://github.com/BryceWG/BiBi-Keyboard/blob/main/README_EN.md)



---

### 語音辨識:

1. **長按錄音** - 簡單直覺的錄音操作

2. **智慧判停** - 靜音自動停止錄音,無需手動操作

3. **極速辨識** - 放開即上傳，快速返回結果 多引擎支援 - 11 個主流 ASR 服務（7 個雲端 + 4 個本地）

4. **本地 ASR 模型** - 支援離線語音識別，無需網絡，保護隱私

5. **AI 文字後處理** - LLM 後處理修正辨識結果
   
   

### 懸浮球輸入:

1. **跨輸入法使用** - 任何輸入法都能語音輸入

2. **無縫整合** - 保持原有輸入習慣

3. **自動插入** - 識別結果自動填入

4. **相容性模式** - 支援 Telegram、抖音等特殊應用

5. **視覺回饋** - 錄音/處理狀態一目了然 
   
   

### 智慧輸入:

1. **AI 編輯面板** - 專用編輯介面，語音指令編輯文字

2. **豐富的編輯工具** - 遊標移動、選擇、複製貼上等完整編輯功能

3. **智慧目標選擇** - 自動辨識編輯目標（選取文字/上次辨識/全文）

4. **自訂按鍵** - 個人化標點符號

5. **小企鵝/同文輸入法連動** - 支援透過修改版小企鵝/同文輸入法直接呼叫「說點啥」的語音辨識能力

6. **外部語音輸入介面** - 支援第三方應用程式透過 SpeechRecognizer 介面呼叫「說點啥」進行語音輸入
   
   

### 使用者體驗:

1. **多種界面風格** - 內建 Material-3 以及 MiuiX 兩種不同風格, 隨心切換

2. **多種界面語言** - 支援**應用程式內顯示**爲 簡體中文、繁體中文、英文、日語

3. **鍵盤高度調整** - 三檔高度自由選擇

4. **測試輸入** - 設定頁內直接測試輸入法

5. **統計功能** - 辨識字數統計

6. **振動回饋** - 按下麥克風時振動回饋

7. ~~自動更新檢查 - 每日開啟軟體自動檢查新版本~~   **(由於更改包名和版本號, 所以可以與原版共存, 但應用更新功能報廢)**
   
   

### 界面展示(平板端):


![設定1](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/assets/hant-1.png)

![設定2](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/assets/hant-2.png)

![設定3](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/assets/hant-3.png)

![輸入佈局](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/assets/hant-4.png)

---

## 二改內容:



#### 你能直接看到的:

1. 在 ***設定 > 輸入設定***  (去除閾值的滑桿下面) 新增 ***繁體中文輸出***  和  ***簡體到繁體中文轉換標準*** (打開選項才能看見~)

2. 在 ***設定 > 關於 > 應用程式***  中的 ***名稱, 版本號, 包名*** 做了修改
   
   

#### 你在修改時才能看到的:

1. 將 ***根目錄/build.gradle.kts*** 第4行 的AGP版本改爲 9.1.1 , 原版是 9.4.1 (當然你也可以自己改)

2. 將 ***/app/build.gradle.kts*** 第28行 的applicationId = "com.brycewg.asrkb" 改爲 "lkg.speechinput.ime" , namespace保持不變

3. 將 ***/app/build.gradle.kts*** 第31-32行 的 versionCode 和 versionName 改爲 500 (500)

4. 將 ***/app/src/mmain/AndroidManiFest.xml***  第6和8行 位於 .permission 前的原包名改爲動態跟隨applicationId

2~4 修改均爲了避免與原版衝突, 並且避免自動更新覆蓋掉此版本, 所以改了個巨大的版本號, 以及換了包名

現在兩者可以同時安裝在同一設備上



---

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


