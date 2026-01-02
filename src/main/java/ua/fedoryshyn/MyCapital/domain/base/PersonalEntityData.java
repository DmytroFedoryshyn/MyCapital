package ua.fedoryshyn.MyCapital.domain.base;

import ua.fedoryshyn.MyCapital.domain.catalog.user.User;

public interface PersonalEntityData extends DomainObjectData {
    User getUser();
}
