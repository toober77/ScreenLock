# 一鍵鎖屏 ScreenLock

點一下桌面圖示就關閉螢幕並上鎖，不用按電源鍵。使用 Android 無障礙服務的「鎖定螢幕」動作，上鎖後**仍可使用指紋／臉部解鎖**。

- 支援 Android 9（API 28）以上
- 點圖示時不顯示任何畫面，直接鎖屏
- 提供快速設定磚塊「鎖定螢幕」
- 不需網路權限、不讀取螢幕內容

## 安裝

1. 到 [Releases](https://github.com/toober77/ScreenLock/releases/latest) 下載 `ScreenLock-v1.1.2.apk`。
2. 在手機上開啟 APK，若出現提示，允許「安裝不明應用程式」。
3. 安裝完成後桌面會出現「一鍵鎖屏」圖示。

## 開啟無障礙權限（第一次使用必做）

1. 點「一鍵鎖屏」圖示，會跳出說明，按「前往設定」。
2. 在無障礙設定中找到「已下載的應用程式」（或「已安裝的服務」）→「一鍵鎖屏」。
3. 開啟開關並按「允許」。
4. 回到桌面再點一次圖示，螢幕就會關閉並上鎖。

> Android 13 以上若開關是灰色的：到「設定 → 應用程式 → 一鍵鎖屏」，點右上角 ⋮ 選「允許受限制的設定」，再回去開啟。

## 快速設定磚塊

下拉通知列兩次 → 點編輯（鉛筆圖示）→ 把「鎖定螢幕」拖到磚塊區，之後點它就能鎖屏。

## 桌面小工具

1. 在桌面空白處長按 → 選「小工具」（或「Widgets」）。
2. 找到「一鍵鎖屏」，把小工具拖到桌面（預設 1×1，可長按後拖拉邊框調整大小，中間電源圖示大小固定）。
3. 點小工具即鎖屏；若尚未開啟無障礙服務，會跳出說明並帶你到設定頁。

## 自行編譯

```
./gradlew assembleRelease
```
簽章設定從 repo 外的 properties 檔讀取（預設 `/workspace/keys/screenlock-signing.properties`，可用環境變數 `SCREENLOCK_SIGNING_PROPS` 指定，或用 `SCREENLOCK_STORE_FILE` / `SCREENLOCK_STORE_PASSWORD` / `SCREENLOCK_KEY_ALIAS` / `SCREENLOCK_KEY_PASSWORD`）。
