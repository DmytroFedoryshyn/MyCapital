package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.OperationType;
import ua.fedoryshyn.MyCapital.domain.base.DomainObject;


@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends DomainObject {
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type", nullable = false)
    private OperationType operationType;

    public Category() {

    }
}
