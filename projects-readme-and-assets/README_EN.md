# Say it ! - Speech Input Method

A smart voice input method powered by AI—using either online services or local models.

Makes your voice input experience more natural and efficient.

Now supports Traditional Chinese output for users who need it.



English can also using smoothly  (〃￣︶￣)人(￣︶￣〃)

* * *

## Multi-Language Introduction:

Traditional Chinese: README.md

Simplified Chinese:

English:

Japanese:



### Original Project Introduction:

Original Project Introduction (Simplified Chinese):



Original Project Introduction (English):



* * *

### Voice Recognition:

1. **Long-press to Record** - Simple and intuitive recording operation.

2. **Smart Stop Detection** - Automatically stops recording during silence; no manual action needed.

3. **Lightning-fast Recognition** - Uploads immediately upon release; rapid result return. Multi-engine support - 11 mainstream ASR services (7 cloud-based + 4 local).

4. **Local ASR Models** - Supports offline voice recognition; no internet required; protects privacy.

5. **AI Text Post-processing** - Uses LLMs to correct and refine recognition results.

### Floating Button Input:

1. **Cross-IME Compatibility** - Enables voice input with any keyboard app.

2. **Seamless Integration** - Maintain your existing typing habits.

3. **Auto-insertion** - Recognition results are automatically filled in.

4. **Compatibility Mode** - Supports special apps like Telegram and Douyin.

5. **Visual Feedback** - Recording and processing status visible at a glance.

### Smart Input:

1. **AI Editing Panel** - Dedicated editing interface; edit text using voice commands.

2. **Rich Editing Tools** - Full editing features including cursor movement, selection, copy/paste, etc.

3. **Smart Target Selection** - Automatically identifies the editing target (selected text / last recognized text / full text).

4. **Customizable Keys** - Personalized punctuation settings.

5. **Integration with Little Penguin / Tongwen Input Method** - Supports directly invoking the "ShuoDianSha" (Say Something) speech recognition capability via modified versions of Little Penguin (XiaoQiE) or Tongwen IME.

6. **External Speech Input Interface** - Supports third-party applications invoking "ShuoDianSha" for speech input via the SpeechRecognizer interface.

### User Experience:

1. **Multiple Interface Styles** - Built-in support for Material-3 and MiuiX styles; switch between them at will.

2. **Multiple Interface Languages** - Supports **in-app display** in Simplified Chinese, Traditional Chinese, English, and Japanese.

3. **Keyboard Height Adjustment** - Freely choose from three height levels.

4. **Test Input** - Test the input method directly within the settings page.

5. **Statistics Function** - Tracks the number of recognized characters.

6. **Haptic Feedback** - Vibration feedback when pressing the microphone button.

7. ~~Automatic Update Check - Automatically checks for new versions upon daily app launch~~ **(Due to changes in the package name and version number, it can coexist with the original version, but the in-app update function is disabled.)**

### Interface Preview (Tablet):

* * *

## Modifications:

#### Visible to the user:

1. Added ***Traditional Chinese Output*** and ***Simplified-to-Traditional Chinese Conversion Standard*** options under ***Settings > Input Settings*** (below the threshold slider; these options only appear when enabled).

2. Modified the ***Name, Version Number, and Package Name*** under ***Settings > About > App***.

#### Visible only during modification:

1. Changed the AGP version on line 4 of ***root/build.gradle.kts*** to 9.1.1 (original was 9.4.1; you can change this yourself).

2. Changed `applicationId = "com.brycewg.asrkb"` on line 28 of ***/app/build.gradle.kts*** to `"lkg.speechinput.ime"`; the namespace remains unchanged.

3. Changed the `versionCode` on lines 31-32 of ***/app/build.gradle.kts***. ...and changed `versionName` to 500 (500).

4. Changed the original package name prefixing `.permission` on lines 6 and 8 of `***/app/src/main/AndroidManifest.xml***` to dynamically follow the `applicationId`.

Modifications 2 through 4 were made to avoid conflicts with the original version and to prevent automatic updates from overwriting this version; hence the massive version number and the changed package name.

Now, both versions can be installed on the same device simultaneously.

* * *

## Warning:

99.9% of the changes in this project were written by the Gemini AI Agent 3.1, while the author (me) is just an ordinary human with almost no coding knowledge...

The remaining 0.1% consists of the package name, version number, and permission identifiers that I manually changed to prevent the original version from overwriting this one.

So, running into issues is perfectly normal~~ even though I wouldn't know how to fix them myself (twiddling fingers).

***Please do not submit bugs encountered while using this project to the original project's issue tracker without first verifying the source of the problem; doing so causes huge headaches for everyone involved!!! Thank you very much!!!***

## Attribution:

**This project is a modification of version 4.1.2 of the voice input method `github.com/BryceWG/BiBi-Keyboard`,**

**and utilizes the OpenCC library (`github.com/qichuan/android-opencc`) for Traditional Chinese output (S2T, S2HK, S2TWP).**

To be honest, I haven't used the Pro version of the original project, nor do I know how its "Traditional Chinese output" is implemented.

My goal isn't to replace or reverse-engineer the original project's Pro version (nor could I).

However, as a user who habitually writes in Traditional Chinese, I wanted a keyboard project I like to be more convenient for daily use—without needing to convert text separately.

That’s why I created this fork, even though the feature happens to be included in the original project's Pro version.

I also believe the original project's Pro version (which is likely AI-driven) probably produces better output than my forced translation using OpenCC.

If you like this input method, please show some support and encouragement to the original project (〃￣︶￣)人(￣︶￣〃). It’s honestly sad that such a great project only has 706 stars.



* * *

Wish u have a nice day ouo. ---qimuan7
