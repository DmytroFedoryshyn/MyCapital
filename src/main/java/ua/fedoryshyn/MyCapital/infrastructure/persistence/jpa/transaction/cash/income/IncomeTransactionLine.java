package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.transaction.cash.income;

import jakarta.persistence.Embeddable;
import org.hibernate.annotations.Parent;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.transaction.cash.CashTransactionLine;

@Embeddable
public class IncomeTransactionLine extends CashTransactionLine {

    @Parent
    private IncomeTransaction transaction;

    // Used by Hibernate.
    protected IncomeTransactionLine() {

    }

    public IncomeTransactionLine(IncomeTransaction transaction) {
        this.transaction = transaction;
    }
}
