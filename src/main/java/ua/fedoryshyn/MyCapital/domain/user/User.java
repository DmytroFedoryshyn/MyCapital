package ua.fedoryshyn.MyCapital.domain.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.domain.base.DomainObject;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends DomainObject {

    @Column(name = "login", nullable = false, unique = true)
    private String login;
}

