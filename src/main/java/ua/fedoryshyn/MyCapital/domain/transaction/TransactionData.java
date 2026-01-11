package ua.fedoryshyn.MyCapital.domain.transaction;

import java.time.LocalDateTime;
import ua.fedoryshyn.MyCapital.domain.base.DomainObjectData;
import ua.fedoryshyn.MyCapital.domain.valueObject.CurrencyAmount;

public interface TransactionData extends DomainObjectData {

    public TransactionType getType();

    public LocalDateTime createdAt();

    public CurrencyAmount amount();

    public String description();
}
