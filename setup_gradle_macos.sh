#!/bin/sh
set -eu
cd "$(dirname "$0")"
curl -fL 'https://raw.githubusercontent.com/gradle/gradle/v8.11.1/gradle/wrapper/gradle-wrapper.jar' -o 'gradle/wrapper/gradle-wrapper.jar'
echo 'Gradle wrapper downloaded. Open this folder in Android Studio.'
