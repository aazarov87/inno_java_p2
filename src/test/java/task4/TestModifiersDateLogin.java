package task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.inno.edu.task4.DTO.DataModel;
import ru.inno.edu.task4.service.impl.ModifyerDateLogin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = ModifyerDateLogin.class)
public class TestModifiersDateLogin {


    @Autowired
    ModifyerDateLogin modifyerDateLogin;

    static final String INPUT_FILE_NAME = "src/main/resources/LogForTestCase";

    @Test
    @DisplayName("Удаление из листа данных с незаполненным dateLogin")
    public  void  testCountRecordsWithNullDate(){

        List<DataModel> list = new ArrayList(Arrays.asList(
                new DataModel( "Login", "Fam", "LastName", "FirstName", "web", null),
                new DataModel( "Login1", "Fam1", "LastName1", "FirstName1", "web", null),
                new DataModel( "Login", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55"))
        ));

        modifyerDateLogin.pathLog = null;
        modifyerDateLogin.modify(list);

        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("Количество записей сохранено, если заполнен dateLogin")
    public  void  testCountRecordsWithoutNullDate(){

        List<DataModel> list = new ArrayList(Arrays.asList(
                new DataModel( "Login", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login1", "Fam1", "LastName1", "FirstName1", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55"))
        ));

        modifyerDateLogin.pathLog = null;
        modifyerDateLogin.modify(list);

        assertEquals(3, list.size());
    }

    @Test
    public  void  testWriteLog() throws IOException {

        List<DataModel> list = new ArrayList(Arrays.asList(
                new DataModel( "Login", "Fam", "LastName", "FirstName", "web", null),
                new DataModel( "Login1", "Fam1", "LastName1", "FirstName1", "web", null),
                new DataModel( "Login", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55"))
        ));

        modifyerDateLogin.pathLog = INPUT_FILE_NAME;
        modifyerDateLogin.modify(list);

        File f = new File(modifyerDateLogin.pathLog);

        List<String> fileStream = Files.readAllLines(Paths.get(modifyerDateLogin.pathLog));
        int countLines = fileStream.size();
        f.delete();

        assertEquals(2, countLines);
    }

}
