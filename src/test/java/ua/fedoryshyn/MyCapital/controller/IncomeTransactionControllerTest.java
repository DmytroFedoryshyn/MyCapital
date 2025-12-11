package ua.fedoryshyn.MyCapital.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.fedoryshyn.MyCapital.dto.CurrencyAmountDto;
import ua.fedoryshyn.MyCapital.dto.IncomeTransactionDto;
import ua.fedoryshyn.MyCapital.mapper.IncomeTransactionMapper;
import ua.fedoryshyn.MyCapital.service.IncomeTransactionService;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.income.IncomeTransaction;

@WebMvcTest(IncomeTransactionController.class)
class IncomeTransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private IncomeTransactionService incomeTransactionService;

    @MockBean
    private IncomeTransactionMapper incomeTransactionMapper;

    @Test
    void createIncomeTransaction() throws Exception {
        IncomeTransactionDto request = new IncomeTransactionDto();
        request.setUserId(UUID.randomUUID());
        request.setWalletId(UUID.randomUUID());
        request.setCreatedAt(LocalDateTime.now());
        CurrencyAmountDto amount = new CurrencyAmountDto();
        amount.setCurrencyId(UUID.randomUUID());
        amount.setAmount(BigDecimal.valueOf(100));
        request.setAmount(amount);

        IncomeTransaction entity = mock(IncomeTransaction.class);

        IncomeTransactionDto response = new IncomeTransactionDto();
        response.setId(UUID.randomUUID());
        response.setUserId(request.getUserId());
        response.setWalletId(request.getWalletId());
        response.setCreatedAt(request.getCreatedAt());
        response.setAmount(amount);

        when(incomeTransactionMapper.toEntity(request)).thenReturn(entity);
        when(incomeTransactionService.save(entity)).thenReturn(entity);
        when(incomeTransactionMapper.toDto(entity)).thenReturn(response);

        mockMvc.perform(post("/income-transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.walletId").value(request.getWalletId().toString()));
    }

    @Test
    void getAllIncomeTransactions() throws Exception {
        IncomeTransaction entity = mock(IncomeTransaction.class);
        IncomeTransactionDto dto = new IncomeTransactionDto();
        dto.setId(UUID.randomUUID());
        dto.setWalletId(UUID.randomUUID());

        when(incomeTransactionService.findAll()).thenReturn(List.of(entity));
        when(incomeTransactionMapper.toDto(entity)).thenReturn(dto);

        mockMvc.perform(get("/income-transactions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(dto.getId().toString()));
    }
}

