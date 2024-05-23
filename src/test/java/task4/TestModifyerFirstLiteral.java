package task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.inno.edu.task4.DTO.DataModel;
import ru.inno.edu.task4.service.impl.ModifyerFirstLiteral;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ModifyerFirstLiteral.class)
public class TestModifyerFirstLiteral {

    @Autowired ModifyerFirstLiteral modifyerFirstLiteral;

    @Test
    @DisplayName("ФИО заглавными буквами")
    public void checkUpperFIO(){
        List<DataModel> list = new ArrayList();
        DataModel dataModel = new DataModel("Login", "fam", "lastName", "firstName", "app", null);
        list.add(dataModel);

        modifyerFirstLiteral.modify(list);

        DataModel dataModelEtalon = new DataModel("Login", "Fam", "LastName", "FirstName", "app", null);

        assertEquals(dataModelEtalon, dataModel);

    }
}
