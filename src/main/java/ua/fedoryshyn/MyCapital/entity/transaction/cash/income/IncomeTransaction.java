package ua.fedoryshyn.MyCapital.entity.transaction.cash.income;

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

import static ua.fedoryshyn.MyCapital.entity.OperationType.INCOME;

@Getter
@Setter
@Entity
@Table(name = "income_transactions")
@DiscriminatorValue("INCOME")
@PrimaryKeyJoinColumn(name = "cash_transaction_id")
public class IncomeTransaction extends CashTransaction {

    @ElementCollection
    @CollectionTable(name = "income_lines")
    private List<IncomeTransactionLine> lines = new ArrayList<>();

    public IncomeTransaction() {
        super(INCOME);
    }
}
