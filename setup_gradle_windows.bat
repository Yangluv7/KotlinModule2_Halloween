@echo off
setlocal
cd /d "%~dp0"
echo Downloading official Gradle 8.11.1 wrapper JAR...
powershell -NoProfile -ExecutionPolicy Bypass -Command "$ErrorActionPreference='Stop'; Invoke-WebRequest -Uri 'https://raw.githubusercontent.com/gradle/gradle/v8.11.1/gradle/wrapper/gradle-wrapper.jar' -OutFile 'gradle/wrapper/gradle-wrapper.jar'; if ((Get-Item 'gradle/wrapper/gradle-wrapper.jar').Length -lt 30000) { throw 'Downloaded file is too small' }"
if errorlevel 1 (
  echo Download failed. Copy gradle-wrapper.jar from a new Android Studio project instead.
  pause
  exit /b 1
)
echo Done. Open this folder with Android Studio.
pause
