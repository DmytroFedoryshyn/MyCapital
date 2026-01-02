package ua.fedoryshyn.MyCapital.domain.catalog.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.OperationType;
import ua.fedoryshyn.MyCapital.domain.base.PersonalDomainObject;


@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category extends PersonalDomainObject {
    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type", nullable = false)
    private OperationType operationType;

    public Category() {

    }
}
