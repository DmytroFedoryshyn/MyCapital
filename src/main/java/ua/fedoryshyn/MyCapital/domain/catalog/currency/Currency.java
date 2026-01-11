package ua.fedoryshyn.MyCapital.domain.catalog.currency;

import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.base.DomainObject;

@Getter
@Setter
public class Currency extends DomainObject {

    private String alphaCode;

    private String numericCode;

    private String symbol;

    private Integer decimals;

    private String name;

    private String flagEmoji;


    public Currency() {

    }
}
