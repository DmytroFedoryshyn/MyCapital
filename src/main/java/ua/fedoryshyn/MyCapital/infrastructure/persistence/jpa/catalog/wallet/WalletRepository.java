package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog.wallet;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<WalletEntity, UUID> {
}
