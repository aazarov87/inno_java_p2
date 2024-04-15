import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.inno.edu.check.RuleNameAcc;
import ru.inno.edu.enumCur.Currancy;
import ru.inno.edu.main.AccSave;
import ru.inno.edu.main.Account;

import java.util.HashMap;

public class SaveAcc {
    @Test
    @DisplayName("Проверка, что при сохранении счета, он не равен последующим изменениям")
    public void TestSave(){
        String etalonName = "EtalonName";

        Account account = new Account(etalonName, new RuleNameAcc(), count -> count < 0);

        account.addCurrancy(Currancy.RUB, 30);

        AccSave accSave = account.getSave();

        account.setName("Name2");

        account.addCurrancy(Currancy.USD, 700);

        Assertions.assertNotEquals(account.getName(), accSave.getName());
        Assertions.assertNotEquals(account.getCountCurrancy(), accSave.getCountCurrancy());
    };

    @Test
    @DisplayName("Проверка, если меняем название счета у эталона, сохранение не изменяется")
    public void TestSaveName(){
        String etalonName = "EtalonName";

        Account account = new Account(etalonName, new RuleNameAcc(), count -> count < 0);

        account.addCurrancy(Currancy.RUB, 30);

        AccSave accSave = account.getSave();

        account.setName("Name2");

        Assertions.assertNotEquals(account.getName(), accSave.getName());
    };

    @Test
    @DisplayName("Проверка, если при сохранении этало н и сохраненный объект равны")
    public void TestSaveEqual(){
        String etalonName = "EtalonName";

        Account account = new Account(etalonName, new RuleNameAcc(), count -> count < 0);

        account.addCurrancy(Currancy.RUB, 30);

        AccSave accSave = account.getSave();

        Assertions.assertEquals(account.getName(), accSave.getName());
    };
}
