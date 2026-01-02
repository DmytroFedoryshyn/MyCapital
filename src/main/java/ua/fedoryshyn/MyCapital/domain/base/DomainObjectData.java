package ua.fedoryshyn.MyCapital.domain.base;

import java.util.UUID;

public interface DomainObjectData {
    UUID getId();

    boolean isActive();
}
