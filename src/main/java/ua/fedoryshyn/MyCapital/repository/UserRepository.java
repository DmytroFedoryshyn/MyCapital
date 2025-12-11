package ua.fedoryshyn.MyCapital.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.fedoryshyn.MyCapital.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
}



