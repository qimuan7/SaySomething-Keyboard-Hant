# 说点啥 - 语音输入法

基于 AI 在线服务或本地模型的语音输入法

让你的语音输入体验更自然, 更高效

添加繁体中文输出, 可以适用需要输出繁体中文的用户 (Ou<)

---

**"2"分支版本相比原版, 只添加了繁体输出, 其他功能跟原版完全一致, 如果没有特殊需求建议用 [原版](https://github.com/BryceWG/BiBi-Keyboard), 或者两个都装上试试**

**如果你想要更简洁的版本, 请查看主分支: [打开](https://github.com/qimuan7/SaySomething-Keyboard-Hant)**

* * *

## 多语介绍 :

繁体 : README.md

简体 : 你正在看~~

英文 : [Open](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/README_EN.md)

日文 : [開ける](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/README_JA.md)

---

### 原项目介绍 :

原项目介绍 (简体中文) :[打开: 简体中文](https://github.com/BryceWG/BiBi-Keyboard/blob/main/README.md)

原项目介绍 (英文) :[Open: English](https://github.com/BryceWG/BiBi-Keyboard/blob/main/README_EN.md)

* * *

## 功能:

### 语音辨识:

1. **长按录音** - 简单直觉的录音操作

2. **智慧判停** - 静音自动停止录音,无需手动操作

3. **极速辨识** - 放开即上传，快速返回结果 多引擎支援 - 11 个主流 ASR 服务（7 个云端 + 4 个本地）

4. **本地 ASR 模型** - 支援离线语音识别，无需网络，保护隐私

5. **AI 文字后处理** - LLM 后处理修正辨识结果


### 悬浮球输入:

1. **跨输入法使用** - 任何输入法都能语音输入

2. **无缝整合** - 保持原有输入习惯

3. **自动插入** - 识别结果自动填入

4. **相容性模式** - 支援 Telegram、抖音等特殊应用

5. **视觉回馈** - 录音/处理状态一目了然


### 智慧输入:

1. **AI 编辑面板** - 专用编辑介面，语音指令编辑文字

2. **丰富的编辑工具** - 游标移动、选择、复制贴上等完整编辑功能

3. **智慧目标选择** - 自动辨识编辑目标（选取文字/上次辨识/全文）

4. **自订按键** - 个人化标点符号

5. **小企鹅/同文输入法连动** - 支援透过修改版小企鹅/同文输入法直接呼叫「说点啥」的语音辨识能力

6. **外部语音输入介面** - 支援第三方应用程式透过 SpeechRecognizer 介面呼叫「说点啥」进行语音输入


### 同步:

1. **多设备同步剪贴簿** - 使用 SyncClipboard 在任何设备上同步你的剪贴簿内容


### 使用者体验:

1. **多种界面风格** - 内建 Material-3 以及 MiuiX 两种不同风格, 随心切换

2. **多种界面语言** - 支援**应用程式内显示**为 简体中文、繁体中文、英文、日语

3. **键盘高度调整** - 三档高度自由选择

4. **测试输入** - 设定页内直接测试输入法

5. **统计功能** - 辨识字数统计

6. **振动回馈** - 按下麦克风时振动回馈

7. ~~自动更新检查 - 每日开启软体自动检查新版本~~ **(由于更改包名和版本号, 所以可以与原版共存, 但应用更新功能报废)**


### 界面展示(平板端):

![設定1](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/assets/hant-1.png)

![設定2](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/assets/hant-2.png)

![設定3](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/assets/hant-3.png)

![輸入佈局](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/2/projects-readme-and-assets/assets/hant-4.png)

* * *

## 使用:

### 系統需求:

1. Android 8.0 (API 26) 或更高版本
  
2. 麥克風權限（語音辨識）
  
3. 懸浮窗權限（可選，用於懸浮球功能）
  
4. 無障礙權限（可選，用於自動插入文字）
  

### 安裝步驟:
  
1. 從 [Releases](https://github.com/qimuan7/SaySomething-Keyboard-Hant/releases) 頁面下載最新版本 APK
  
2. 安裝到 Android 設備
  

### 啟用輸入法:

> 設定 → 系統 → 語言與輸入法 → 虛擬鍵盤 → 管理鍵盤 → 啟用"「說點啥」"

### 配置 ASR 服務

1. 打開說點啥設置
  
2. 選擇 ASR 供應商（建議：火山引擎）
  
3. 填入 API 金鑰
  

### 開始使用~

1. 在任意輸入框切換說點啥輸入法
  
2. 長按麥克風按鈕然後說點啥 (說啥我也不知道xd)

---

## 二改内容:


#### 你能直接看到的:

1. 在 ***设置 > 输入设置*** (去除阈值的滑杆下面) 新增 ***繁体中文输出*** 和 ***简体到繁体中文转换标准*** (打开选项才能看见~)

2. 在 ***设定 > 关于 > 应用程式*** 中的 ***名称, 版本号, 包名*** 做了修改


#### 你在修改时才能看到的:

1. 将 ***根目录/build.gradle.kts*** 第4行 的AGP版本改为 9.1.1 , 原版是 9.4.1 (当然你也可以自己改)

2. 将 ***/app/build.gradle.kts*** 第28行 的applicationId = "com.brycewg.asrkb" 改为 "lkg.speechinput.ime" , namespace保持不变

3. 将 ***/app/build.gradle.kts*** 第31-32行 的 versionCode 和 versionName 改为 500 (500)

4. 将 ***/app/src/mmain/AndroidManiFest.xml*** 第6和8行 位于 .permission 前的原包名改为动态跟随applicationId

2~4 修改均为了避免与原版冲突, 并且避免自动更新覆盖掉此版本, 所以改了个巨大的版本号, 以及换了包名

现在两者可以同时安装在同一设备上

* * *

## 警告:

此项目的更改 99.9% 都由 Gemini AI Agent 3.1 编写, 而作者(我)是一个几乎不懂代码的普通人类...

剩下 0.1% 是我为了避被原版覆盖更新而手动改的包名, 版本号, 和 权限识别码.

所以遇到问题是很正常的~~ 尽管我也不知道怎么修 (蹲地上画圈圈

***请不要在没有确定问题是哪来的以前, 把使用这个项目遇到的 bug 丢到原项目 issus, 这会对彼此造成巨大的困扰 !!! 非常感谢 !!!***


## 所属声明:

**此项目使用语音输入法 github.com/BryceWG/BiBi-Keyboard 的 4.1.2 版本二改,**

**使用 github.com/qichuan/android-opencc 的 OpenCC 库 (S2T, S2HK, S2TWP) 实现繁体中文输出**

说实话我没有用过原项目的Pro版, 也不知道里面的"繁体中文输出"如何实现

我的目标不是取代或者破解原项目的Pro版本 (也做不到),

但我作为惯用繁体字的用户, 希望喜欢的键盘项目可以被更方便的日用, 而不需要另外转换文字

所以我创建了这个分支, 只是它刚好也在原项目的Pro版的功能清单里

我也相信原项目的Pro版 (或许) 基于AI输出, 会有比我用 OpenCC 强行转换有更好的输出效果

如果你喜欢这个输入法, 请多多给予原项目一点支援和鼓励吧 (〃￣︶￣)人(￣︶￣〃) 这么好的项目只有 706 star 真的很难过的好嘛

* * *

愿你今日快乐ouo. --qimuan7

---
