package ua.fedoryshyn.MyCapital.entity.transaction.cash;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.entity.OperationType;
import ua.fedoryshyn.MyCapital.entity.Wallet;
import ua.fedoryshyn.MyCapital.entity.transaction.Transaction;

import static ua.fedoryshyn.MyCapital.entity.TransactionType.CASH;

@Getter
@Setter
@Entity
@Table(name = "cash_transactions")
@PrimaryKeyJoinColumn(name = "transaction_id")
@DiscriminatorColumn(name = "operation_type")
public abstract class CashTransaction extends Transaction {

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type", nullable = false, insertable = false, updatable = false)
    private OperationType operationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    protected CashTransaction(OperationType type) {
        super(CASH);
        this.operationType = type;
    }
}
