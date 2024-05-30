package task5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.inno.edu.task5.controller.ProductRegisterController;
import ru.inno.edu.task5.dto.PgRegistryInput;
import ru.inno.edu.task5.service.TppProductRegisterService;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ProductRegisterControllerTestMock {

    @Mock
    private TppProductRegisterService tppProductRegisterService;

    @InjectMocks
    private ProductRegisterController productRegisterController;
    private MockMvc mockMvc;


    private ObjectMapper objectMapper;

    @BeforeEach
    void Setuo(){
        mockMvc = MockMvcBuilders.standaloneSetup(productRegisterController).build();
        objectMapper = new ObjectMapper();
    }
    @Test
    @DisplayName("Вызов контроллера и получение HttpStatus.OK")
    void ProductRegistryOk() throws Exception {
        PgRegistryInput pgRegistryInput = new PgRegistryInput(3434, "RegType", "AccType", "cur", "001", "prior", "mdm", "clCode", "trainReg", "count", "saleCode");

        String pgRegistryInputjson = objectMapper.writeValueAsString(pgRegistryInput);
        mockMvc.perform(post("/corporate-settlement-account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pgRegistryInputjson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @DisplayName("Вызов контроллера и получение HttpStatus.BAD_REQUEST, если вна вход подаем данные без заполненного поля помеченного  @NotNull в DTO")
    void ProductRegistry() throws Exception {
        PgRegistryInput pgRegistryInput = new PgRegistryInput(null, "RegType", "AccType", "cur", "001", "prior", "mdm", "clCode", "trainReg", "count", "saleCode");

        String pgRegistryInputjson = objectMapper.writeValueAsString(pgRegistryInput);

        mockMvc.perform(post("/corporate-settlement-account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pgRegistryInputjson))
                .andExpect(status().isBadRequest());
    }
}
