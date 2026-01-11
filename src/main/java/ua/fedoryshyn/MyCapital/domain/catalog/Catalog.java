package ua.fedoryshyn.MyCapital.domain.catalog;

import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.base.DomainObject;

@Getter
@Setter
public abstract class Catalog extends DomainObject {
    private String name;

    protected Catalog(CatalogData data) {
        super(data);
        this.name = data.getName();
    }
}
