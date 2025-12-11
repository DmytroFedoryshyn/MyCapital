package ua.fedoryshyn.MyCapital.entity;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import lombok.Getter;

@Getter
@Embeddable
public final class CurrencyAmount {
    private Currency currency;
    private BigDecimal amount;

    @SuppressWarnings("unused")
    private CurrencyAmount() {

    }

    public CurrencyAmount(Currency currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
