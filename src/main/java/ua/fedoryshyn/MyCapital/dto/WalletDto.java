package ua.fedoryshyn.MyCapital.dto;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletDto {
    private UUID id;
    private String name;
    private BigDecimal balance;
    private String currency;
    private String title;
}
