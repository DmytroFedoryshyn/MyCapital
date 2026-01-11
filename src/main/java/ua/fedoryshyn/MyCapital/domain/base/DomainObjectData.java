package ua.fedoryshyn.MyCapital.domain.base;

import java.util.UUID;
import ua.fedoryshyn.MyCapital.domain.user.User;

public interface DomainObjectData {
    public UUID getId();

    public boolean isActive();

    public User getUser();
}
