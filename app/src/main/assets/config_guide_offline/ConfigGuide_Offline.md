本地模型配置指南
--------

本地模型适合隐私优先与离线使用。不同模型在速度、效果、是否流式上各有取舍。



---

### 模型选择建议

* **SenseVoice**：非流式；速度快、均衡；支持语言设置
* **FunASR Nano**：非流式；支持语言选择、原生 ITN，并提供 MLT Nano 多语言变体
* **Qwen3-ASR**：非流式；本地 0.6B 模型，中文效果较好
* **Parakeet**：非流式；V3 适合多种欧洲语言，V2 适合英语
* **FireRedASR V2**：非流式 / 伪流式；替代旧版 TeleSpeech，支持中英本地识别
* **X-ASR**：本地流式；中英 480ms 模型，支持线程数、模型卸载策略与可选 ITN



---

### 在应用内下载（推荐）

1. 选择本地模型供应商（如 SenseVoice / X-ASR）
2. 在模型管理页选择版本并点击下载
3. 如已授予通知权限，可在通知栏查看下载与解压进度



---

### 通过本地文件导入（可选）

如果你偏好通过本地文件添加模型，可先下载 ZIP，再在模型管理页选择“从本地导入”。

模型直链

以下为 `BiBi-Keyboard` 模型 ZIP 直链；如遇到 404/下载慢，请前往 [模型库（Releases: models）](https://github.com/BryceWG/BiBi-Keyboard/releases/tag/models) 或使用 GitHub 镜像站下载。

#### SenseVoice（非流）

* small-int8（约 153MB）：[sherpa-onnx-sense-voice-zh-en-ja-ko-yue-int8-2024-07-17.zip](https://github.com/BryceWG/BiBi-Keyboard/releases/download/models/sherpa-onnx-sense-voice-zh-en-ja-ko-yue-int8-2024-07-17.zip)
* small-fp32（约 980MB）：[sherpa-onnx-sense-voice-zh-en-ja-ko-yue-2024-07-17.zip](https://github.com/BryceWG/BiBi-Keyboard/releases/download/models/sherpa-onnx-sense-voice-zh-en-ja-ko-yue-2024-07-17.zip)

#### X-ASR（流式）

* 中英 480ms（约 530MB）：[sherpa-onnx-streaming-x-asr-480ms-zh-en.zip](https://github.com/BryceWG/BiBi-Keyboard/releases/download/models/sherpa-onnx-streaming-x-asr-480ms-zh-en.zip)

#### FireRedASR V2（非流 / 伪流）

* Zh + En CTC int8（约 740MB）：[sherpa-onnx-fire-red-asr2-ctc-zh_en-int8-2026-02-25.zip](https://github.com/BryceWG/BiBi-Keyboard/releases/download/models/sherpa-onnx-fire-red-asr2-ctc-zh_en-int8-2026-02-25.zip)

#### FunASR Nano（非流）

* int8（约 690MB）：[sherpa-onnx-funasr-nano-int8-2025-12-30.zip](https://github.com/BryceWG/BiBi-Keyboard/releases/download/models/sherpa-onnx-funasr-nano-int8-2025-12-30.zip)
* MLT Nano int8（约 690MB）：[sherpa-onnx-funasr-mlt-nano-int8-2026-03-21.zip](https://github.com/BryceWG/BiBi-Keyboard/releases/download/models/sherpa-onnx-funasr-mlt-nano-int8-2026-03-21.zip)

#### Qwen3-ASR（非流）

* 0.6B int8（约 806MB）：[sherpa-onnx-qwen3-asr-0.6B-int8-2026-03-25.zip](https://github.com/BryceWG/BiBi-Keyboard/releases/download/models/sherpa-onnx-qwen3-asr-0.6B-int8-2026-03-25.zip)

#### Parakeet（非流）

* 0.6B V3 int8（约 456MB）：[sherpa-onnx-nemo-parakeet-tdt-0.6b-v3-int8.zip](https://github.com/BryceWG/BiBi-Keyboard/releases/download/models/sherpa-onnx-nemo-parakeet-tdt-0.6b-v3-int8.zip)
* 0.6B V2 int8（约 451MB）：[sherpa-onnx-nemo-parakeet-tdt-0.6b-v2-int8.zip](https://github.com/BryceWG/BiBi-Keyboard/releases/download/models/sherpa-onnx-nemo-parakeet-tdt-0.6b-v2-int8.zip)

#### 通用标点模型（可选）

* int8（约 59MB）：[sherpa-onnx-punct-ct-transformer-zh-en-vocab272727-2024-04-12-int8.zip](https://github.com/BryceWG/BiBi-Keyboard/releases/download/models/sherpa-onnx-punct-ct-transformer-zh-en-vocab272727-2024-04-12-int8.zip)
