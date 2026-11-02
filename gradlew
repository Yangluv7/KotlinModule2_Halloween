#!/usr/bin/env sh
APP_HOME=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
if [ ! -f "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" ]; then
  echo 'Gradle wrapper jar is missing. Run: sh setup_gradle_macos.sh' >&2
  exit 1
fi
exec java -classpath "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
