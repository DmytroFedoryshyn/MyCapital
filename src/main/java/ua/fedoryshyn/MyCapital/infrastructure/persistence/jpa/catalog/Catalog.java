package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.base.DomainObject;

@Getter
@Setter
@MappedSuperclass
public abstract class Catalog extends DomainObject {
    @Column(name = "name")
    private String name;

    protected Catalog() {

    }
}
