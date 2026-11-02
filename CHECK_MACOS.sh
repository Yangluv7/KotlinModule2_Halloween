#!/bin/sh
set -eu
cd "$(dirname "$0")"
if [ ! -f gradle/wrapper/gradle-wrapper.jar ]; then sh setup_gradle_macos.sh; fi
sh ./gradlew :app:assembleDebug
echo "APK: app/build/outputs/apk/debug/app-debug.apk"
