@echo off
setlocal
set "APP_HOME=%~dp0"
if not exist "%APP_HOME%gradle\wrapper\gradle-wrapper.jar" (
  echo Gradle wrapper jar is missing. First run setup_gradle_windows.bat
  exit /b 1
)
java -classpath "%APP_HOME%gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
