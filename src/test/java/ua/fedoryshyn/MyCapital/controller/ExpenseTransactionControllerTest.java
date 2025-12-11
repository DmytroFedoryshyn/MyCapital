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
import ua.fedoryshyn.MyCapital.dto.ExpenseTransactionDto;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.expense.ExpenseTransaction;
import ua.fedoryshyn.MyCapital.mapper.ExpenseTransactionMapper;
import ua.fedoryshyn.MyCapital.service.ExpenseTransactionService;

@WebMvcTest(ExpenseTransactionController.class)
class ExpenseTransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ExpenseTransactionService expenseTransactionService;

    @MockBean
    private ExpenseTransactionMapper expenseTransactionMapper;

    @Test
    void createExpenseTransaction() throws Exception {
        ExpenseTransactionDto request = new ExpenseTransactionDto();
        request.setUserId(UUID.randomUUID());
        request.setWalletId(UUID.randomUUID());
        request.setCreatedAt(LocalDateTime.now());
        CurrencyAmountDto amount = new CurrencyAmountDto();
        amount.setCurrencyId(UUID.randomUUID());
        amount.setAmount(BigDecimal.valueOf(50));
        request.setAmount(amount);

        ExpenseTransaction entity = mock(ExpenseTransaction.class);

        ExpenseTransactionDto response = new ExpenseTransactionDto();
        response.setId(UUID.randomUUID());
        response.setUserId(request.getUserId());
        response.setWalletId(request.getWalletId());
        response.setCreatedAt(request.getCreatedAt());
        response.setAmount(amount);

        when(expenseTransactionMapper.toEntity(request)).thenReturn(entity);
        when(expenseTransactionService.save(entity)).thenReturn(entity);
        when(expenseTransactionMapper.toDto(entity)).thenReturn(response);

        mockMvc.perform(post("/expense-transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.walletId").value(request.getWalletId().toString()));
    }

    @Test
    void getAllExpenseTransactions() throws Exception {
        ExpenseTransaction entity = mock(ExpenseTransaction.class);
        ExpenseTransactionDto dto = new ExpenseTransactionDto();
        dto.setId(UUID.randomUUID());
        dto.setWalletId(UUID.randomUUID());

        when(expenseTransactionService.findAll()).thenReturn(List.of(entity));
        when(expenseTransactionMapper.toDto(entity)).thenReturn(dto);

        mockMvc.perform(get("/expense-transactions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(dto.getId().toString()));
    }
}



