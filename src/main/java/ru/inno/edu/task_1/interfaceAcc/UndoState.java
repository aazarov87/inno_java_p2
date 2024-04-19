package ru.inno.edu.task_1.interfaceAcc;

import ru.inno.edu.task_1.main.Account;

// интерфейс для отката состояния счета
public interface UndoState {
    void undo(Account acc);
}
