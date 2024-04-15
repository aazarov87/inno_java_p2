import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;
import ru.inno.edu.check.RuleNameAcc;
import ru.inno.edu.enumCur.Currancy;
import ru.inno.edu.main.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountTest {
    @Test
    @DisplayName("Проверка, что имя счета не может быть пустым при создание объекта")
    public void TestNameIsNotNullCreate(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Account("", new RuleNameAcc(), count -> count < 0));
    };

    @Test
    @DisplayName("Проверка, что имя счета совпадает с переданным при создание объекта")
    public void TestNameEqualseCreate(){
        String name = "name Acc";

        Account account = new Account(name, new RuleNameAcc(), count -> count < 0);

        Assertions.assertEquals(name, account.getName());
    };

    @Test
    @DisplayName("Проверка, что имя счета не может быть пустым при изменение имени счета")
    public void TestNameIsNotNullSetName(){
        Account acc = new Account("AccName", new RuleNameAcc(), count -> count < 0);
        Assertions.assertThrows(IllegalArgumentException.class, () ->  acc.setName(""));
    };

    @Test
    @DisplayName("Проверка, что имя счета совпадает с переданным изменение имени счета")
    public void TestNameEqualseSetName(){
        String name = "name Acc";

        Account account = new Account(name, new RuleNameAcc(), count -> count < 0);

        name = "New name";
        account.setName(name);

        Assertions.assertEquals(name, account.getName());
    };

    @Test
    @DisplayName("Проверка, что при добавлении отрицательного количества валюты возникает ошибка")
    public void TestCurransyNotInRange(){
        Account account = new Account("name", new RuleNameAcc(), count -> count < 0);

        //HashMap<Currancy, Integer> currancyIntegerHashMap = new HashMap<>();

        Assertions.assertThrows(IllegalArgumentException.class, () ->  account.addCurrancy(Currancy.RUB, -1));
    };

    @Test
    @DisplayName("Проверка, что при добавлении отрицательного количества валюты возникает ошибка")
    public void TestCurransyInRange(){
        Account account = new Account("name", new RuleNameAcc(), count -> count < 0);

        HashMap<Currancy, Integer> currancyIntegerHashMap = new HashMap<>();
        currancyIntegerHashMap.put(Currancy.RUB, 30);
        currancyIntegerHashMap.put(Currancy.EUR, 50);
        currancyIntegerHashMap.put(Currancy.USD, 700);

        for (Map.Entry<Currancy, Integer> entry : currancyIntegerHashMap.entrySet()) {
            account.addCurrancy(entry.getKey(), entry.getValue());
        }

        Assertions.assertEquals(account.getCountCurrancy(), currancyIntegerHashMap);
    };
}
