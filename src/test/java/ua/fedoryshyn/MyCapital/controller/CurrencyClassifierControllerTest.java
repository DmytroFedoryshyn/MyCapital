package ua.fedoryshyn.MyCapital.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.fedoryshyn.MyCapital.dto.CurrencyClassifierDto;
import ua.fedoryshyn.MyCapital.entity.CurrencyClassifier;
import ua.fedoryshyn.MyCapital.mapper.CurrencyClassifierMapper;
import ua.fedoryshyn.MyCapital.service.CurrencyClassifierService;

@WebMvcTest(CurrencyClassifierController.class)
class CurrencyClassifierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CurrencyClassifierService classifierService;

    @MockBean
    private CurrencyClassifierMapper classifierMapper;

    @Test
    void createClassifier() throws Exception {
        CurrencyClassifierDto request = new CurrencyClassifierDto();
        request.setAlphaCode("USD");
        request.setNumericCode("840");
        request.setName("US Dollar");

        CurrencyClassifier entity = new CurrencyClassifier();

        CurrencyClassifierDto response = new CurrencyClassifierDto();
        response.setAlphaCode("USD");
        response.setNumericCode("840");
        response.setName("US Dollar");

        when(classifierMapper.toEntity(any(CurrencyClassifierDto.class)))
            .thenReturn(entity);
        when(classifierService.save(entity))
            .thenReturn(entity);
        when(classifierMapper.toDto(entity))
            .thenReturn(response);

        mockMvc.perform(post("/currency-classifiers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.alphaCode").value("USD"))
            .andExpect(jsonPath("$.name").value("US Dollar"));
    }

    @Test
    void getAllClassifiers() throws Exception {
        CurrencyClassifier entity = new CurrencyClassifier();

        CurrencyClassifierDto dto = new CurrencyClassifierDto();
        dto.setAlphaCode("EUR");
        dto.setNumericCode("978");
        dto.setName("Euro");

        when(classifierService.findAll()).thenReturn(List.of(entity));
        when(classifierMapper.toDto(entity)).thenReturn(dto);

        mockMvc.perform(get("/currency-classifiers"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].alphaCode").value("EUR"));
    }
}
