package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.inno.edu.task_1.check.RuleNameAcc;
import ru.inno.edu.task_1.enumCur.Currancy;
import ru.inno.edu.task_1.main.Account;
import java.util.Map;
import java.util.NoSuchElementException;

public class UndoTest {

    @Test
    @DisplayName("Проверка, что при отмене всех изменений остановились на первоначальном значение")
    public void TestUndoAllAction(){
        String etalonName = "EtalonName";

        Account account = new Account(etalonName, new RuleNameAcc(), count -> count < 0);
        Map<Currancy, Integer> currancyEtalon = account.getCountCurrancy();

        account.setName("Name2");
        account.addCurrancy(Currancy.RUB, 30);
        account.addCurrancy(Currancy.USD, 700);

        account.undo();
        account.undo();
        account.undo();

        Assertions.assertEquals(account.getName(), etalonName);
        Assertions.assertEquals(account.getCountCurrancy(), currancyEtalon);
    };

    @Test
    @DisplayName("Проверка, что при отмене большего количества действий, чем сохранено, возникает ошибка")
    public void TestUndoMoreThanExists(){
        String etalonName = "EtalonName";
        Account account = new Account(etalonName, new RuleNameAcc(), count -> count < 0);

        Assertions.assertThrows(NoSuchElementException.class, () ->  account.undo());
    };

    @Test
    @DisplayName("Проверка, что при вызове отмены, удаляется добавленная валюта")
    public void TestEqualCursUndo(){
        String etalonName = "EtalonName";

        Account account = new Account(etalonName, new RuleNameAcc(), count -> count < 0);
        Map<Currancy, Integer> currancyEtalon = account.getCountCurrancy();

        account.setName("Name2");
        account.addCurrancy(Currancy.RUB, 30);
        currancyEtalon = account.getCountCurrancy();

        account.addCurrancy(Currancy.USD, 700);

        account.undo();
        Assertions.assertEquals(account.getCountCurrancy(), currancyEtalon);
    };

    @Test
    @DisplayName("Проверка, что при вызове отмены, изменная валюта возвращается в предыдущее состояние")
    public void TestEqualEditCursUndo(){
        String etalonName = "EtalonName";

        Account account = new Account(etalonName, new RuleNameAcc(), count -> count < 0);
        Map<Currancy, Integer> currancyEtalon = account.getCountCurrancy();

        account.setName("Name2");
        account.addCurrancy(Currancy.RUB, 30);
        currancyEtalon = account.getCountCurrancy();

        account.addCurrancy(Currancy.RUB, 700);

        account.undo();
        Assertions.assertEquals(account.getCountCurrancy(), currancyEtalon);
    };
}
