package ua.fedoryshyn.MyCapital.dto;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyAmountDto {
    private UUID currencyId;
    private BigDecimal amount;
}





