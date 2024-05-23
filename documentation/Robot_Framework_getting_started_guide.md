# Руководство по началу работы с Robot Framework

Существуют различные подходы к настройке окружения для автоматизации тестирования с помощью Robot Framework, и далее
представлен один из них — насколько возможно, в руководстве задействована
официальная документация [Robot Framework Guides](https://docs.robotframework.org/docs), а специфичные моменты проекта
раскрываются более подробно.

1. Начать стоит с установки актуальной версии
   [Python](https://docs.robotframework.org/docs/getting_started/testing#install-python).
2. Затем нужно установить [PyCharm](https://docs.robotframework.org/docs/getting_started/ide#pycharm) — интегрированную
   среду разработки (IDE).
3. В PyCharm требуется
   [создать новый проект](https://www.jetbrains.com/help/pycharm/creating-and-running-your-first-python-project.html#creating-simple-project).
   В процессе по умолчанию создаётся также и виртуальное окружение
   ([project venv](https://pym.dev/virtual-environments-in-python)) с версией Python из шага 1.
    - Проверить корректность этого можно в
      [терминале PyCharm](https://www.jetbrains.com/help/pycharm/terminal-emulator.html) (Alt+F12): приглашение
      командной строки должно начинаться с `(.venv) ...`, при выполнении команды `python -V` выводится установленная
      версия Python (например, `Python 3.12.3`).
    - 📦 Если виртуальное окружение не было создано автоматически, то нужно
      [создать его вручную](https://www.jetbrains.com/help/pycharm/creating-virtual-environment.html).
4. Далее следует установить расширение
   [Robot Framework Language Server](https://docs.robotframework.org/docs/getting_started/ide#pycharm-extensions),
5. а затем добавить конфигурацию запуска для Robot Framework (Alt+Shift+F10, больше об этом в
   [документации PyCharm](https://www.jetbrains.com/help/pycharm/run-debug-configuration.html#createExplicitly))
   — её параметры указаны в документации из прошлого шага.
6. Затем следует перейти в настройки (Ctrl+Alt+S) ➡ Languages & Frameworks ➡ Robot Framework (Project) и в Language
   Server Python (первая строка) прописать путь к
   [интерпретатору Python из виртуального окружения проекта](https://www.jetbrains.com/help/pycharm/installing-uninstalling-and-reloading-interpreter-paths.html#view)
   (путь можно скопировать из диалогового окна "Show All...", упоминаемого в инструкции). Например, для Windows по
   умолчанию он выглядит так:
   `C:\<user>\PycharmProjects\<project_name>\.venv\Scripts\python.exe` (`<user>` и `<project_name>` нужно заменить на
   собственные).
7. Для завершения настройки нужно установить ряд библиотек — в терминале (как в шаге 3.1) последовательно выполнить
   команды:
    - `python -m pip install robotframework-requests`,
    - `python -m pip install robotframework-jsonlibrary`,
    - `python -m pip install robotframework-seleniumlibrary`.
    - ℹ После выполнения каждой команды в терминале должно присутствовать сообщение `Successfully installed ...`, а
      также должны отсутствовать сообщения об ошибках.
8. Теперь достаточно [создать файл](https://www.jetbrains.com/help/pycharm/populating-projects.html)
   ([другой способ](https://www.jetbrains.com/guide/python/tips/navbar-create-file/)) с расширением `.robot`, в котором
   и будет располагаться код автотеста
   ([пример API-автотеста](../exercises/robot-framework/address-suggestions-api-test.robot),
   [пример UI-автотеста](../exercises/robot-framework/address-suggestions-ui-test.robot)).
9. Процесс запуска автотестов отражён в
   [документации](https://docs.robotframework.org/docs/getting_started/ide#pycharm-with-robot-framework-language-server).
   Результаты локального запуска выводятся в
   [окно запуска PyCharm](https://www.jetbrains.com/help/pycharm/run-tool-window.html).
10. 🎞 Также для более детального ознакомления с Robot Framework доступны
    [видеоинструкции](https://docs.robotframework.org/docs/getting_started/videos).
