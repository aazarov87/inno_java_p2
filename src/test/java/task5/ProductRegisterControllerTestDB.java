package task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.inno.edu.task5.StartRestApp;
import ru.inno.edu.task5.controller.ProductRegisterController;
import ru.inno.edu.task5.dto.PgRegistryInput;

import org.junit.jupiter.api.*;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.inno.edu.task5.exceptions.NotExistsData;
import ru.inno.edu.task5.model.AccountModel;
import ru.inno.edu.task5.model.AccountPoolModel;
import ru.inno.edu.task5.model.TppProductRegisterModel;
import ru.inno.edu.task5.model.TppProductRegisterTypeModel;
import ru.inno.edu.task5.repo.AccountPoolRepo;
import ru.inno.edu.task5.repo.AccountRepo;
import ru.inno.edu.task5.repo.TppProductRegisterRepo;
import ru.inno.edu.task5.repo.TppProductRegisterTypeRepo;
import ru.inno.edu.task5.service.TppProductRegisterService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = StartRestApp.class)
public class ProductRegisterControllerTestDB {

    @Autowired
    private TppProductRegisterService tppProductRegisterService;

    @Autowired
    static MockMvc mockMvc;

    @Autowired
    ProductRegisterController productRegisterController;

    @Autowired
    TppProductRegisterTypeRepo tppProductRegisterTypeRepo;

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    AccountPoolRepo accountPoolRepo;

    @Autowired
    TppProductRegisterRepo tppProductRegisterRepo;

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:15-alpine"
    );

    private static ObjectMapper objectMapper;
    @BeforeAll
    static void beforeAll(){
        postgres.start();
        objectMapper = new ObjectMapper();
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
        tppProductRegisterTypeRepo.deleteAll();
        tppProductRegisterRepo.deleteAll();

        TppProductRegisterTypeModel tppProductRegisterTypeModel1 = new TppProductRegisterTypeModel(2323, "03.012.002_47533_ComSoLd", "registerTypeName", "productClassCode", null, null, "accountType");
        tppProductRegisterTypeRepo.save(tppProductRegisterTypeModel1);

        AccountPoolModel accountPoolModel = new AccountPoolModel(null, "0022", "800", "15", "00", "03.012.002_47533_ComSoLd");
        accountPoolRepo.save(accountPoolModel);

        AccountModel accountModel = new AccountModel(null, accountPoolModel.getId(), "475335516415314841861", false);
        accountRepo.save(accountModel);
    }

    @Test
    @DisplayName("Данные в БД отсутствуют. Ловим NotExistsData.class")
    public void test() throws Exception {
        System.out.println("productRegister =" + productRegisterController);

        PgRegistryInput pgRegistryInput = new PgRegistryInput(3434, "scsdc", "AccType", "800", "0022", "00", "15", "clientCode", "trainRegion", "counter", "salesCode");

        Assertions.assertThrows(NotExistsData.class, () ->  tppProductRegisterService.add(pgRegistryInput));
    }

    @Test
    @DisplayName("Успешной создание tppProductRegister с переданными значениями")
    public void test1() throws Exception {
        PgRegistryInput pgRegistryInput = new PgRegistryInput(3434, "03.012.002_47533_ComSoLd", "AccType", "800", "0022", "00", "15", "clientCode", "trainRegion", "counter", "salesCode");

        assertEquals(tppProductRegisterService.add(pgRegistryInput).getProductId(), 3434);
    }
}
