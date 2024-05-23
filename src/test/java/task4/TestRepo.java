package task4;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.inno.edu.task4.*;
import ru.inno.edu.task4.DTO.DataModel;
import ru.inno.edu.task4.model.Logins;
import ru.inno.edu.task4.model.Users;
import ru.inno.edu.task4.repo.LoginsRepo;
import ru.inno.edu.task4.repo.UserRepo;
import ru.inno.edu.task4.service.DataReader;
import ru.inno.edu.task4.service.DataWriter;
import ru.inno.edu.task4.service.impl.DataReaderFileImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(CommandLineRunner.class)

@SpringBootTest(classes = StartMigr.class)
public class TestRepo {

    @Autowired
    UserRepo userRepo;

    @Autowired
    LoginsRepo loginsRepo;

    @Autowired
    DataWriter writer;

    @Autowired
    DataReaderFileImpl datareader;

    static final String OUTPUT_FILE_NAME = "src/main/resources/SourceDataForTest/";

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );

    @BeforeAll
    static void beforeAll(){
        postgres.start();
    }

    @AfterAll
    static void afterAll(){
        postgres.stop();
    }

    @DynamicPropertySource
    static  void configureProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
        dynamicPropertyRegistry.add("spring.datasource.url", postgres::getJdbcUrl);
        dynamicPropertyRegistry.add("spring.datasource.username", postgres::getUsername);
        dynamicPropertyRegistry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeEach
    void setUp(){
        userRepo.deleteAll();
        loginsRepo.deleteAll();
    }

    @Test
    @DisplayName("Количество записей в таблицах")
    public  void  testCountUsers(){

        List<DataModel> list = new ArrayList(Arrays.asList(
                new DataModel( "Login", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login1", "Fam1", "LastName1", "FirstName1", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login2", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55"))
        ));

        writer.write(list);

        assertEquals(3, userRepo.findAll().size());
        assertEquals(3, loginsRepo.findAll().size());
    }

    @Test
    @DisplayName("Количество записей в таблицах, если у одного пользователя несколько авторизаций")
    public  void  testCountUsersDouble(){

        List<DataModel> list = new ArrayList(Arrays.asList(
                new DataModel( "Login", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login1", "Fam1", "LastName1", "FirstName1", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login2", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login2", "Fam", "LastName", "FirstName", "mobile", LocalDateTime.parse("2023-07-18T11:13:55"))
        ));

        writer.write(list);

        assertEquals(3, userRepo.findAll().size());
        assertEquals(4, loginsRepo.findAll().size());
        assertEquals(4, loginsRepo.findAll().size());
    }

    @Test
    @DisplayName("Количество авторизаций у одного пользователя")
    public  void  testCountLogins(){

        List<DataModel> list = new ArrayList(Arrays.asList(
                new DataModel( "Login1", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login1", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login2", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login2", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55")),
                new DataModel( "Login2", "Fam", "LastName", "FirstName", "mobile", LocalDateTime.parse("2023-07-18T11:13:55"))
        ));

        writer.write(list);

        Users users = userRepo.findByUsername("Login2");

        List<Logins> logins = loginsRepo.findByUserId(users.getId());

        assertEquals(3, logins.size());
        assertEquals(5, loginsRepo.findAll().size());
        assertEquals(2, userRepo.findAll().size());
    }

    @Test
    @DisplayName("Проверка полученной строки из БД по Users")
    public  void  testCheckFieldsUsersFromDB(){

        Users userEtalon = new Users("Login1", "Fam FirstName LastName");

        List<DataModel> list = new ArrayList(Arrays.asList(
                new DataModel( "Login1", "Fam", "LastName", "FirstName", "web", LocalDateTime.parse("2023-06-18T10:13:55"))
        ));

        writer.write(list);

        Users users = userRepo.findByUsername("Login1");

        users.setId(null);
        assertEquals(users, userEtalon);
    }

    @Test
    @DisplayName("Чтение данных из файла")
    public  void  testReader(){
        datareader.dataSourceForReader.folderName = OUTPUT_FILE_NAME;

        List<DataModel> linesFromFile = (List<DataModel>) datareader.read();

        assertEquals(5, linesFromFile.size());
    }
}
