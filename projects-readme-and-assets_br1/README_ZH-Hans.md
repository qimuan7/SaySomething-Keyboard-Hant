# 语音输入 - 偏执的离线语音输入体验

使用离线 AI 模型的语音输入法

基于 [说点啥(Saysomething)](https://github.com/BryceWG/BiBi-Keyboard) 输入法

使用 [OpenCC](https://github.com/qichuan/android-opencc) 提供繁体中文输入

移除在线功能, 还你一个即使没有互联网也依然可靠的语音输入方式

---

## Multi Languages Introduction :

繁体中文 : README.md

简体中文 : 你正在阅读 (ouo)

English : [Open](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/1/projects-readme-and-assets_br1/README_EN.md)

日本语 : [开ける](https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/1/projects-readme-and-assets_br1/README_JA.md)

---

### Original Project's Introduction:

原项目介绍 (简体中文) : [打开: 简体中文](https://github.com/BryceWG/BiBi-Keyboard/blob/main/README.md)

Original Project's Introduction (English) : [Open: English](https://github.com/BryceWG/BiBi-Keyboard/blob/main/README_EN.md)

---


## 功能:


### 语音辨识:

- 可识别语言涵盖 普通话, 粤语, 地方语言, 英文, 日文, 及更多

- 完全离线的语音识别模型, 从 100MB 到 800MB, 快速, 准确, 稳定, 保护私隐


### 输入与界面:

- AI编辑面板, 只需语音指令即可编辑文字

- 可自订按键布局

- Material-3 和 MiuiX 界面风格

- 多语言显示: 简体中文、繁体中文、英文、日语

- 极简初始设定


### 更多功能: 我只当做普通语音输入法用, 部分功能可以等你去发现~


### 界面展示(平板端):

- **界面展示(中文):**  https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/1/projects-readme-and-assets_br1/assets/ui-1-zh.mp4

- **输入展示(三语):**  https://github.com/qimuan7/SaySomething-Keyboard-Hant/blob/1/projects-readme-and-assets_br1/assets/type-en-md-ct.mp4
---

## 使用:

### 系统:

- Android 8.0 (API 26) 或更高版本

### 权限:

- 麦克风权限（必须，用于语音辨识）

- 悬浮窗权限（可选，用于悬浮球功能）

- 无障碍权限（可选，用于自动插入文字）

### 安装 & 启用:

1. 从 [Releases](https://github.com/qimuan7/SaySomething-Keyboard-Hant/releases) 页面下载 "Spime_**BR1**_vXXX(XXX).apk" 版本 APK

2. 安装到 Android 设备

3. 根据初始画面获取权限: 设定 → 系统 → 语言与输入法 → 虚拟键盘 → 管理键盘 → 启用"「语音输入」"

### 下载模型:

1. 打开设定

2. 选择喜欢的语音辨识服务商, 选择模型大小并点击一键下载

- 若想要手动下载, 前往设定-语音辨识设定-去查看配置教学, 即可唤起内嵌的离线配置指导页面, 你可以在其中找到模型下载连结, 或在 [Release-ModelDownload]() 中下载保存

### 使用~

- 在任意输入框切换说点啥输入法, 并长按麦克风按钮即可开始辨识

---

## 原版, 分支2, 以及该版本的区别 (二改内容):

### [原版](https://github.com/BryceWG/BiBi-Keyboard)

- 拥有一切基础功能

- 拥有原版应用更新

- 没有繁体中文输入

- 附带在线服务与可选的数据收集

### [分支2 (此仓库另一分支)](https://github.com/qimuan7/SaySomething-Keyboard-Hant/tree/2)

- 相比较原版, **拥有同样的全部功能 & 内容**

- **额外添加繁体中文输入**

- **没有(检查)更新**

- **可以与原版共存, 不能与分支1共存**

### [分支1 (此分支)](https://github.com/qimuan7/SaySomething-Keyboard-Hant/)

- 相比较原版, **除保留模型下载功能, 移除所有在线功能** (WebDAV备份, 匿名资料收集, 剪贴簿同步, 更新与检查更新, Pro版本宣传, ...)

- **隐藏所有在线AI服务商** (改为默认使用离线模型, 内嵌原在线配置教学文档)

- 替换原项目名称, **中文** 改为 **空白** 或 **"语音输入"** ; **英文** 改为 **空白** 或 **"Speech Input"**

- **额外添加繁体中文输入**

- **可以与原版共存, 不能与分支2共存**

---

## 注意:

如名称所言, 这一分支将所有在线功能移除, 并去除原版名称, 它是 "偏执的个人习惯" 下的产物, 并不适用于每个人

我编译最初只是为了给自己用, 所以做了许多看起来奇怪且非必要的更改.

移除在线功能是因为我对在线的不信任, 担心身处于断网的位置时手机的所有功能都会无法使用, 所以这只是一次普通的替代.

移除原项目名字并非想要偷取或另立门户, 只是 "BIBI" 这个词勾起我的阴影, 所以我在此分支将其移除

如果你想要原版的体验, 奈何没有繁体输入, 你可以尝试使用分支2, 那是纯粹的原版+繁体输出

## 警告:

此项目的更改 99.9% 都由 Gemini AI Agent 3.1 编写, 而作者(我)是一个几乎不懂代码的普通人类...

剩下 0.1% 是我为了避被原版覆盖更新而手动改的包名, 版本号, 和 权限识别码.

所以遇到问题是很正常的~~ 尽管我也不知道怎么修 (对手指

***请不要在没有确定问题是哪来的以前, 把使用这个项目遇到的 bug 丢到原项目 issus, 这会对彼此造成巨大的困扰 !!! 非常感谢 !!!***


## 所属声明:

**此项目使用语音输入法 github.com/BryceWG/BiBi-Keyboard 的 4.1.2 版本二改,**

**使用 github.com/qichuan/android-opencc 的 OpenCC 库 (S2T, S2HK, S2TWP) 实现繁体中文输出**

讲实话我没有用过原项目的Pro版, 也不知道其中的"繁体中文输出"如何实现

我的目标不是取代或者破译原项目的Pro版本 (也做不到),

但我作为惯用繁体字的用户, 希望喜欢的键盘项目可以被更方便的日用, 而不需要另外转换文字

所以我创建了这个分支, 只是它刚好也在原项目的Pro版的功能清单里

我也相信原项目的Pro版 (或许) 基于AI输出, 会有比我用 OpenCC 强行转换有更好的输出效果

如果你喜欢这个输入法, 请多多给予原项目一点支援和鼓励吧 (〃￣︶￣)人(￣︶￣〃) 这么好的项目只有 706 star 真的很难过好嘛

---

愿你今日快乐ouo. --qimuan7

---
