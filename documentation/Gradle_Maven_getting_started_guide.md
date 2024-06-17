# Руководство по началу работы с Gradle и Maven

1. Начать стоит с установки [IntelliJ IDEA](https://www.jetbrains.com/help/idea/installation-guide.html) —
   интегрированной среды разработки (IDE).
2. В IDEA требуется [создать новый проект Gradle](https://www.jetbrains.com/help/idea/getting-started-with-gradle.html).
   При необходимости также нужно [сконфигурировать SDK](https://www.jetbrains.com/help/idea/sdk.html#define-sdk).
3. Теперь в [src/test/java/test](../src/test/java/test) достаточно
   [создать Java Class-ы](https://www.jetbrains.com/help/idea/add-items-to-project.html#new-java-class), в которых и
   будет располагаться код автотестов.
    - [Пример API-автотеста (RestAssured)](../src/test/java/test/AddressSuggestionsRestAssuredApiTest.java).
    - [Пример API-автотеста (Playwright)](../src/test/java/test/AddressSuggestionsPlaywrightApiTest.java).
    - [Пример UI-автотеста (Selenide)](../src/test/java/test/AddressSuggestionsSelenideUiTest.java) с применением
      [Page Object Model](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/).
    - [Пример UI-автотеста (Playwright)](../src/test/java/test/AddressSuggestionsPlaywrightUiTest.java).
4. Для запуска примеров автотестов требуется вся структура файлов из [src/test/java](../src/test/java). Также в
   [build.gradle](../build.gradle) нужно:
    - добавить в блок `dependencies` используемые зависимости (версии стоит использовать актуальные):
        - `testImplementation "io.rest-assured:rest-assured:5.4.0"`
          ([GitHub](https://github.com/rest-assured/rest-assured?tab=readme-ov-file#news));
        - `testImplementation "com.microsoft.playwright:playwright:1.44.1"`
          ([GitHub](https://github.com/microsoft/playwright/releases));
        - `testImplementation "com.codeborne:selenide:7.3.2"`
          ([GitHub](https://github.com/selenide/selenide/releases));
    - указать кодировку компиляции тестовых классов — `java {compileTestJava.options.encoding = "UTF-8"}`).
5. Процесс запуска автотестов отражён
   в [документации](https://www.jetbrains.com/help/idea/getting-started-with-gradle.html#test_gradle) (и доступен
   [запуск из терминала](https://docs.gradle.org/current/userguide/command_line_interface.html)).
6. Также возможно добавить
   [поддержку Maven](https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html#add_maven_support)
   к проекту, и процесс запуска автотестов с его помощью отражён в
   [соответствующей документации](https://maven.apache.org/guides/getting-started/index.html#how-do-i-compile-my-test-sources-and-run-my-unit-tests).
   Пример файла [pom.xml](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) имеется в
   [репозитории](../pom.xml).
