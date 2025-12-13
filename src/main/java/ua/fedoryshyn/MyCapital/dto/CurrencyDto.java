package ua.fedoryshyn.MyCapital.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyDto {
    private UUID id;
    private String alphaCode;
    private String numericCode;
    private String symbol;
    private Integer decimals;
    private String name;
    private Boolean isActive;
    private String flagEmoji;
    private UUID userId;
}





