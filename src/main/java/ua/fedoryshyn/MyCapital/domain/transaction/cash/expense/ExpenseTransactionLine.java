package ua.fedoryshyn.MyCapital.domain.transaction.cash.expense;

import jakarta.persistence.Embeddable;
import org.hibernate.annotations.Parent;
import ua.fedoryshyn.MyCapital.domain.transaction.cash.CashTransactionLine;

@Embeddable
public class ExpenseTransactionLine extends CashTransactionLine {

    @Parent
    private ExpenseTransaction transaction;

    // Used by Hibernate.
    protected ExpenseTransactionLine() {

    }

    public ExpenseTransactionLine(ExpenseTransaction transaction) {
        this.transaction = transaction;
    }
}
