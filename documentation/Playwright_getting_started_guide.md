# Руководство по началу работы с Playwright

1. Начать стоит с установки актуальной версии
   [Python](https://docs.robotframework.org/docs/getting_started/testing#install-python).
2. Затем нужно установить [PyCharm Community](https://www.jetbrains.com/help/pycharm/installation-guide.html) —
   интегрированную среду разработки (IDE).
3. В PyCharm требуется
   [создать новый проект](https://www.jetbrains.com/help/pycharm/creating-and-running-your-first-python-project.html#creating-simple-project).
   В процессе по умолчанию создаётся также и виртуальное окружение
   ([project venv](https://pym.dev/virtual-environments-in-python)) с версией Python из шага 1.
    - Проверить корректность этого можно в
      [терминале PyCharm](https://www.jetbrains.com/help/pycharm/terminal-emulator.html): приглашение командной строки
      должно начинаться с `(.venv) ...`, при выполнении команды `python -V` выводится установленная версия Python
      (например, `Python 3.12.3`).
    - 📦 Если виртуальное окружение не было создано автоматически, то нужно
      [создать его вручную](https://www.jetbrains.com/help/pycharm/creating-virtual-environment.html).
4. Для завершения настройки нужно установить плагин pytest для Playwright — в терминале (как в шаге 3.1) выполнить
   команду `python -m pip install pytest-playwright`. ℹ После выполнения команды в терминале должно присутствовать
   сообщение `Successfully installed ...`, а также должны отсутствовать сообщения об ошибках. (Для UI-тестов также
   нужно установить браузеры командой `playwright install`.)
5. Теперь достаточно [создать Python File](https://www.jetbrains.com/help/pycharm/populating-projects.html)
   ([другой способ](https://www.jetbrains.com/guide/python/tips/navbar-create-file/)) с именем `test_*.py` или
   `\*_test.py`, в котором и будет располагаться код автотеста
   ([пример API-автотеста](../exercises/playwright/address_suggestions_api_test.py),
   [пример UI-автотеста](../exercises/playwright/address_suggestions_ui_test.py)).
6. [Запуск автотестов](https://playwright.dev/python/docs/intro#running-the-example-test) производится с помощью
   команды `pytest`. Результаты локального запуска выводятся в терминале, в котором были запущены автотесты.
7. Также для ознакомления с pytest доступно
   [руководство по началу работы с ним](../documentation/pytest_getting_started_guide.md).
