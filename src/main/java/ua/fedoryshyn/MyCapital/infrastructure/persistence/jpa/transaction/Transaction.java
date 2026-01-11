package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.base.DomainObject;
import ua.fedoryshyn.MyCapital.domain.transaction.TransactionData;
import ua.fedoryshyn.MyCapital.entity.base.HibernateEntity;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.valueObject.CurrencyAmount;

@Getter
@Setter
@Entity
@Table(name = "transactions")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class Transaction extends HibernateEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "type", insertable = false, updatable = false)
    private TransactionType type;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "amount", nullable = false)
    private CurrencyAmount amount;

    @Column(name = "description")
    private String description;

    protected Transaction(TransactionData data) {

    }

    protected Transaction(TransactionType type) {
        this.type = type;
    }
}
