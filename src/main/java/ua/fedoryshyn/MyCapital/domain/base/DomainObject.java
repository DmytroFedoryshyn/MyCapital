package ua.fedoryshyn.MyCapital.domain.base;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import ua.fedoryshyn.MyCapital.domain.user.User;

@Getter
@Setter
@MappedSuperclass
public abstract class DomainObject {

    @Id
    private final UUID id;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected DomainObject() {
        id = UUID.randomUUID();
    }

    protected DomainObject(DomainObjectData data) {
        this.id = data.getId();
        this.active = data.isActive();
        this.user = data.getUser();
    }
}
