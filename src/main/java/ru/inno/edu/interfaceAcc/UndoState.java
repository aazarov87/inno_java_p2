package ru.inno.edu.interfaceAcc;

import ru.inno.edu.main.Account;

// интерфейс для отката состояния счета
public interface UndoState {
    void undo(Account acc);
}
