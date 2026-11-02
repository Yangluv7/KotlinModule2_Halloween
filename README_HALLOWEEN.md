# KotlinModule2 Halloween

Отдельная копия проекта с хэллоуинским главным меню. Учебный проект KotlinModule2 и отчёт для сдачи сохранены отдельно.

Оформление: тёмная иллюстрация с луной, летучими мышами и тыквами; десять оранжевых кнопок в два столбца. Тёмный фон, карточки и оранжевые кнопки применены также внутри заданий. Логика заданий прежняя.

- Интерфейс меню: `app/src/main/java/com/example/kotlinmodule2/HalloweenMenu.kt`.
- Фон: `app/src/main/res/drawable/halloween_background.xml`.
- Тыква: `app/src/main/res/drawable/pumpkin.xml`.
- Имя приложения: Kotlin • Halloween.
- Идентификатор: com.example.kotlinmodule2.halloween — устанавливается рядом с обычной версией.

В Android Studio откройте эту папку. Для Gradle выберите JDK 17. Требуется Android SDK 35.

Сборка: `./gradlew assembleDebug`.

Проверено на эмуляторе Android 15 / API 35: сборка успешна, 4 инструментальных теста прошли. Скриншот меню и протокол тестов находятся в `preview/`.
