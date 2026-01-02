package ua.fedoryshyn.MyCapital.domain.catalog.currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.base.PersonalDomainObject;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "currency")
public class Currency extends PersonalDomainObject {

    @Column(name = "alpha_code", length = 3, nullable = false)
    private String alphaCode;

    @Column(name = "numeric_code", length = 3, nullable = false)
    private String numericCode;

    @Column(name = "symbol", length = 5, nullable = false)
    private String symbol;

    @Column(name = "decimals", nullable = false)
    private Integer decimals;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "flag_emoji", length = 8)
    private String flagEmoji;


    public Currency() {

    }
}
