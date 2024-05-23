# Руководство по началу работы с Robot Framework

Существуют различные подходы к настройке окружения для автоматизации тестирования с помощью Robot Framework, и далее
представлен один из них. Насколько возможно, в руководстве задействуется
[официальная документация Robot Framework Guides](https://docs.robotframework.org/docs), а специфичные моменты проекта
раскрываются более подробно.

1. Начать стоит с установки актуальной
   версии [Python](https://www.python.org/downloads/) —
   [более подробная инструкция](https://docs.robotframework.org/docs/getting_started/testing#install-python).
2. Затем нужно установить интегрированную среду разработки (IDE)
   [PyCharm](https://docs.robotframework.org/docs/getting_started/ide#pycharm).
3. В PyCharm требуется создать новый проект: в процессе по умолчанию создаётся также и виртуальное окружение (project
   venv) с версией Python из шага 1. Проверить корректность этого можно в терминале PyCharm (Alt+F12): приглашение
   командной строки будет начинаться с `(.venv) ...`, а при вводе команды `python -V` будет выводиться установленная
   версия Python (например, `Python 3.12.3`).
4. Далее следует установить
   [необходимые расширения](https://docs.robotframework.org/docs/getting_started/ide#pycharm-extensions),
5. а затем добавить конфигурацию запуска (Alt+Shift+F10, больше об этом в
   [документации PyCharm](https://www.jetbrains.com/help/pycharm/run-debug-configuration.html)) — параметры указаны в
   документации из прошлого шага.
6. Затем следует перейти в настройки (Ctrl+Alt+S), Languages & Frameworks, Robot Framework (Project) и в первой строке,
   Language Server Python, прописать путь к исполняемому файлу Python из виртуального окружения. Например, для Windows
   по умолчанию он выглядит так: `C:\<user>\PycharmProjects\<project_name>\.venv\Scripts\python.exe` (`<user>`
   и `<project_name>` нужно заменить на собственные).
7. Для завершения настройки нужно установить ряд библиотек — в терминале (как в шаге 3) последовательно выполнить
   команды: `python -m pip install robotframework-requests`, `python -m pip install robotframework-jsonlibrary`,
   `python -m pip install robotframework-seleniumlibrary`.
8. Теперь достаточно [создать файл](https://www.jetbrains.com/guide/python/tips/navbar-create-file/) с расширением
   `.robot`, в котором и будет располагаться код автотеста.
9. Процесс запуска автотестов отражён в
   [документации](https://docs.robotframework.org/docs/getting_started/ide#pycharm-with-robot-framework-language-server).
 
[Пример API-автотеста](../exercises/address-suggestions-api-test.robot).
[Пример UI-автотеста](../exercises/address-suggestions-ui-test.robot).
