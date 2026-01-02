package ua.fedoryshyn.MyCapital.application.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CashTransactionLineDto {
    private UUID categoryId;
    private CurrencyAmountDto amount;
}





