# Руководство по началу работы с pytest

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
4. Для завершения настройки нужно установить ряд библиотек — в терминале (как в шаге 3.1) последовательно выполнить
   команды:
    - `python -m pip install pytest`,
    - `python -m pip install requests`,
    - `python -m pip install selenium`.
    - ℹ После выполнения каждой команды в терминале должно присутствовать сообщение `Successfully installed ...`, а
      также должны отсутствовать сообщения об ошибках.
5. Теперь достаточно [создать Python File](https://www.jetbrains.com/help/pycharm/populating-projects.html)
   ([другой способ](https://www.jetbrains.com/guide/python/tips/navbar-create-file/)) с именем `test_*.py` или
   `\*_test.py`, в котором и будет располагаться код автотеста
   ([пример API-автотеста](../exercises/pytest/address_suggestions_api_test.py),
   [пример UI-автотеста](../exercises/pytest/address_suggestions_ui_test.py)).
6. Процесс запуска автотестов отражён в [документации](https://docs.pytest.org/en/stable/how-to/usage.html).
   Результаты локального запуска выводятся в терминале, в котором были запущены автотесты.
7. Также для более детального ознакомления с pytest доступны
   [примеры и тонкости настройки](https://docs.pytest.org/en/stable/example/index.html).
