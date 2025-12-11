package ua.fedoryshyn.MyCapital.entity.transaction.cash.expense;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.CashTransaction;

import static ua.fedoryshyn.MyCapital.entity.OperationType.EXPENSE;

@Getter
@Setter
@Entity
@Table(name = "expense_transactions")
@DiscriminatorValue("EXPENSE")
@PrimaryKeyJoinColumn(name = "cash_transaction_id")
public class ExpenseTransaction extends CashTransaction {

    @ElementCollection
    @CollectionTable(name = "expense_lines")
    private List<ExpenseTransactionLine> lines = new ArrayList<>();

    public ExpenseTransaction() {
        super(EXPENSE);
    }
}
