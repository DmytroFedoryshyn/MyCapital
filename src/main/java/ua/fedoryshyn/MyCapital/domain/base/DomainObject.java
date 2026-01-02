package ua.fedoryshyn.MyCapital.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@MappedSuperclass
public abstract class DomainObject {

    @Id
    @UuidGenerator
    private UUID id;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;
}
