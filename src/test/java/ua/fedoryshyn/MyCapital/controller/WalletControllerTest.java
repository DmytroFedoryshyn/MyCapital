package ua.fedoryshyn.MyCapital.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.fedoryshyn.MyCapital.dto.WalletDto;
import ua.fedoryshyn.MyCapital.service.WalletService;

@WebMvcTest(WalletController.class)
class WalletControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private WalletService walletService;

    @Test
    void createWallet() throws Exception {
        WalletDto request = new WalletDto();
        request.setName("Main");
        request.setBalance(BigDecimal.TEN);
        request.setCurrency("USD");

        WalletDto response = new WalletDto();
        response.setId(UUID.randomUUID());
        response.setName("Main");
        response.setBalance(BigDecimal.TEN);
        response.setCurrency("USD");

        when(walletService.createWallet(request)).thenReturn(response);

        mockMvc.perform(post("/wallets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Main"))
                .andExpect(jsonPath("$.currency").value("USD"));
    }

    @Test
    void getAllWallets() throws Exception {
        WalletDto dto = new WalletDto();
        dto.setId(UUID.randomUUID());
        dto.setName("Spare");
        dto.setBalance(BigDecimal.ONE);
        dto.setCurrency("EUR");

        when(walletService.getAllWallets()).thenReturn(List.of(dto));

        mockMvc.perform(get("/wallets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Spare"));
    }
}



