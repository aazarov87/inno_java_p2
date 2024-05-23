package task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.inno.edu.task4.DTO.DataModel;
import ru.inno.edu.task4.service.impl.ModifyerAppsName;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = ModifyerAppsName.class)
public class TestModifyerAppsName {

    @Autowired
    ModifyerAppsName modifyerAppsName;

    @Test
    @DisplayName("Приложение web")
    public  void  testCheckNameAppWeb() {
        String app = "web";
        List<DataModel> list = new ArrayList();
        DataModel dataModel = new DataModel("Login", "fam", "lastName", "firstName", app, null);
        list.add(dataModel);

        modifyerAppsName.modify(list);

        assertEquals(app, list.get(0).getTypeApp());
    }

    @Test
    @DisplayName("Приложение mobile")
    public  void  testCheckNameAppMobile() {
        String app = "mobile";
        List<DataModel> list = new ArrayList();
        DataModel dataModel = new DataModel("Login", "fam", "lastName", "firstName", app, null);
        list.add(dataModel);

        modifyerAppsName.modify(list);

        assertEquals(app, list.get(0).getTypeApp());
    }

    @Test
    @DisplayName("Приложение other")
    public  void  testCheckNameAppOther() {
        String app = "app";
        List<DataModel> list = new ArrayList();
        DataModel dataModel = new DataModel("Login", "fam", "lastName", "firstName", app, null);
        list.add(dataModel);

        modifyerAppsName.modify(list);

        assertEquals("other: " + app, list.get(0).getTypeApp());
    }
}
