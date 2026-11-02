@echo off
setlocal
cd /d "%~dp0"
if not exist gradle\wrapper\gradle-wrapper.jar (
  call setup_gradle_windows.bat
  if errorlevel 1 exit /b 1
)
call gradlew.bat :app:assembleDebug
if errorlevel 1 (
  echo BUILD FAILED. Send Android Studio Build Output for troubleshooting.
  pause
  exit /b 1
)
echo BUILD SUCCESS. APK: app\build\outputs\apk\debug\app-debug.apk
pause
