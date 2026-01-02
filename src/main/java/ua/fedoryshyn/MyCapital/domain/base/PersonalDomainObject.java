package ua.fedoryshyn.MyCapital.domain.base;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.catalog.user.User;

@Getter
@Setter
@MappedSuperclass
public abstract class PersonalDomainObject extends DomainObject {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
