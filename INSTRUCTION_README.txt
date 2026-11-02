МОДУЛЬ 2 — Kotlin / Jetpack Compose (10 практических заданий)

1) Откройте папку KotlinModule2 в Android Studio (File > Open).
2) Установите Android SDK Platform 35 и JDK 17 (если Studio попросит).
3) Официальный gradle-wrapper.jar уже включён. Дождитесь Gradle Sync.
   Для Gradle выберите JDK 17: встроенный JDK 25 новой Studio несовместим с Gradle 8.11.1.
4) Запустите эмулятор Android либо подключите Android-устройство.
5) Run > Run 'app'. На главном экране выберите любое задание 1–10.
6) Задание 2: откройте Tasks1to5.kt и посмотрите Compose Preview для
   HelloPreviewPortrait, HelloPreviewLandscape, HelloPreviewRound.
7) Задание 9: файл app/src/androidTest/java/com/example/kotlinmodule2/WaterTrackerTest.kt
   > правый клик по имени класса > Run 'WaterTrackerTest'.
   Тесты работают только на эмуляторе или реальном Android-устройстве.
8) Задание 1: по методичке надо собрать два варианта — с Hello("Артём")
   и Hello(null). В Task1Screen присутствуют ОБА варианта; для строго
   двух отдельных сборок закомментируйте один из вызовов и выполните Run,
   затем поменяйте вызовы местами и повторите Run.

КОД ИЗ КАКОГО ФАЙЛА:
1–5: Tasks1to5.kt
6–8: Tasks6to8.kt
9: WaterTrackerTest.kt
10: ShoppingCart.kt

Сборка и UI-тесты на эмуляторе Android 15 проверены. Реальные изображения и результаты тестов приложены к итоговому отчёту.
