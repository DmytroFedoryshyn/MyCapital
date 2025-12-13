package ua.fedoryshyn.MyCapital.entity;

import java.time.LocalDateTime;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.CashTransaction;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cash_flow_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CashFlowRecord {

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
}
