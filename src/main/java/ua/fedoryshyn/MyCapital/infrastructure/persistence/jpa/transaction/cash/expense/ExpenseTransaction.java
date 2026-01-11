package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.transaction.cash.expense;

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
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.OperationType;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.transaction.cash.CashFlowRecord;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.transaction.cash.CashTransaction;

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
        super(OperationType.EXPENSE);
    }

    public ExpenseTransactionLine addLine() {
        ExpenseTransactionLine newLine = new ExpenseTransactionLine(this);
        lines.add(newLine);
        return newLine;
    }

    @Override
    public void syncMovements() {
        clearCashFlowRecords();
        if (isActive()) {
            for (ExpenseTransactionLine line: lines) {
                CashFlowRecord record = addCashFlowRecord();
                record.setDate(getCreatedAt());
                record.setUser(getUser());
                record.setWallet(getWallet());
                record.setCategory(line.getCategory());
                record.setAmount(line.getAmount());
            }
        }
    }
}
