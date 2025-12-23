package ua.fedoryshyn.MyCapital.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.fedoryshyn.MyCapital.dto.CurrencyDto;
import ua.fedoryshyn.MyCapital.entity.Currency;
import ua.fedoryshyn.MyCapital.mapper.CurrencyMapper;
import ua.fedoryshyn.MyCapital.service.CurrencyService;

@WebMvcTest(CurrencyController.class)
class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CurrencyService currencyService;

    @MockBean
    private CurrencyMapper currencyMapper;

    @Test
    void createCurrency() throws Exception {
        CurrencyDto request = new CurrencyDto();
        request.setAlphaCode("USD");
        request.setNumericCode("840");
        request.setName("US Dollar");
        request.setActive(true);

        Currency entity = new Currency();

        CurrencyDto response = new CurrencyDto();
        response.setId(UUID.randomUUID());
        response.setAlphaCode("USD");
        response.setNumericCode("840");
        response.setName("US Dollar");
        response.setActive(true);

        when(currencyMapper.toEntity(any(CurrencyDto.class)))
            .thenReturn(entity);
        when(currencyService.save(entity))
            .thenReturn(entity);
        when(currencyMapper.toDto(entity))
            .thenReturn(response);

        mockMvc.perform(post("/currencies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.alphaCode").value("USD"))
            .andExpect(jsonPath("$.name").value("US Dollar"));
    }

    @Test
    void getAllCurrencies() throws Exception {
        Currency entity = new Currency();

        CurrencyDto dto = new CurrencyDto();
        dto.setId(UUID.randomUUID());
        dto.setAlphaCode("EUR");
        dto.setNumericCode("978");
        dto.setName("Euro");

        when(currencyService.findAll()).thenReturn(List.of(entity));
        when(currencyMapper.toDto(entity)).thenReturn(dto);

        mockMvc.perform(get("/currencies"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].alphaCode").value("EUR"));
    }
}
