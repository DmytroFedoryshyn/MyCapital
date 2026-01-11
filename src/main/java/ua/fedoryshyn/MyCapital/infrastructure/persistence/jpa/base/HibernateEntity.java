package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.base;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import ua.fedoryshyn.MyCapital.domain.user.User;

public abstract class HibernateEntity {
    @Id
    private UUID id;

    @Column(name = "is_active", nullable = false)
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    protected HibernateEntity() {
        // Used by Hibernate.
    }
}
