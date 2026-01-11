package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.transaction.cash;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.catalog.category.Category;
import ua.fedoryshyn.MyCapital.entity.base.HibernateEntity;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog.wallet.Wallet;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.user.User;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.valueObject.CurrencyAmount;

@Entity
@Table(name = "cash_flow_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CashFlowRecord extends HibernateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "transaction_id", nullable = false)
    private CashTransaction transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "value", column = @Column(name = "amount_value", nullable = false)),
        @AttributeOverride(name = "currency", column = @Column(name = "amount_currency", length = 3, nullable = false))
    })
    private CurrencyAmount amount;

    public CashFlowRecord(CashTransaction transaction) {
        this.transaction = transaction;
    }
}
