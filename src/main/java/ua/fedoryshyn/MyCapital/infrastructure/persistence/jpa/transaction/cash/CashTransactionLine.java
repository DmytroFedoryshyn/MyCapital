package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.transaction.cash;

import jakarta.persistence.Embedded;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.catalog.category.Category;
import ua.fedoryshyn.MyCapital.entity.base.HibernateEntity;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.valueObject.CurrencyAmount;

/**
 * A line of income in the IncomeTransaction.
 * */
@Getter
@Setter
@MappedSuperclass
public class CashTransactionLine extends HibernateEntity {

    protected CashTransactionLine() {

    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Embedded
    private CurrencyAmount amount;
}
