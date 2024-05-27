# Руководство по началу работы с Gradle

1. Начать стоит с установки [IntelliJ IDEA](https://www.jetbrains.com/help/idea/installation-guide.html) —
   интегрированной среды разработки (IDE).
2. В IDEA требуется [создать новый проект Gradle](https://www.jetbrains.com/help/idea/getting-started-with-gradle.html).
   При необходимости также нужно [сконфигурировать SDK](https://www.jetbrains.com/help/idea/sdk.html#define-sdk).
3. Теперь в [src/test/java/test](../src/test/java/test) достаточно
   [создать Java Class](https://www.jetbrains.com/help/idea/add-items-to-project.html#new-java-class), в котором и будет
   располагаться код автотеста
   ([пример API-автотеста](../src/test/java/test/AddressSuggestionsApiTest.java),
   [пример UI-автотеста](../src/test/java/test/AddressSuggestionsUiTest.java) с применением
   [Page Object Model](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)).
4. Для запуска примеров автотестов требуется вся структура файлов из [src/test/java](../src/test/java), а также в
   [build.gradle](../build.gradle) нужно:
    - добавить в блок `dependencies` используемые зависимости:
        - `testImplementation "io.rest-assured:rest-assured:5.4.0"` (версию стоит использовать
          [актуальную](https://github.com/rest-assured/rest-assured?tab=readme-ov-file#news)) — для API-теста;
        - `testImplementation "com.codeborne:selenide:7.3.2"` (версию стоит использовать
          [актуальную](https://github.com/selenide/selenide/releases)) — для UI-теста;
    - указать кодировку компиляции тестовых классов — `java {compileTestJava.options.encoding = "UTF-8"}`).
5. Процесс запуска автотестов отражён
   в [документации](https://www.jetbrains.com/help/idea/getting-started-with-gradle.html#test_gradle) (также
   доступен [запуск из терминала](https://docs.gradle.org/current/userguide/command_line_interface.html)).
