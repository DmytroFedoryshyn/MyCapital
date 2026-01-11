package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog.classifier.currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.entity.base.HibernateEntity;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "currency_classifier")
public class CurrencyClassifier extends HibernateEntity {

    @Id
    @Column(name = "alpha_code", length = 3, nullable = false, updatable = false)
    private String alphaCode;

    @Column(name = "numeric_code", length = 3, nullable = false, unique = true)
    private String numericCode;

    @Column(name = "symbol", length = 5)
    private String symbol;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "flag_emoji", length = 8)
    private String flagEmoji;
}

