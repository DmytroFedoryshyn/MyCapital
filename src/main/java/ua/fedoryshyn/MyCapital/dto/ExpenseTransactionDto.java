package ua.fedoryshyn.MyCapital.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpenseTransactionDto {
    private UUID id;
    private UUID userId;
    private UUID walletId;
    private LocalDateTime createdAt;
    private CurrencyAmountDto amount;
    private String description;
    private Boolean active;
    private List<CashTransactionLineDto> lines;
}






