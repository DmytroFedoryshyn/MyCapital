package ua.fedoryshyn.MyCapital.entity.transaction;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import ua.fedoryshyn.MyCapital.entity.CashFlowRecord;
import ua.fedoryshyn.MyCapital.entity.CurrencyAmount;
import ua.fedoryshyn.MyCapital.entity.TransactionType;
import ua.fedoryshyn.MyCapital.entity.User;
import ua.fedoryshyn.MyCapital.entity.base.PersonalEntity;

@Getter
@Setter
@Entity
@Table(name = "transactions")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class Transaction extends PersonalEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "type", insertable = false, updatable = false)
    private TransactionType type;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "amount", nullable = false)
    private CurrencyAmount amount;

    @Column(name = "description")
    private String description;

//    protected Transaction() {
//
//    }

    protected Transaction(TransactionType type) {
        this.type = type;
    }
}
