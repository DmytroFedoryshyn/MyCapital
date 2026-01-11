package ua.fedoryshyn.MyCapital.domain.catalog.category;

import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.OperationType;
import ua.fedoryshyn.MyCapital.domain.base.DomainObject;


@Getter
@Setter
public class Category extends DomainObject {
    private String name;

    private OperationType operationType;

    public Category() {

    }
}
