package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog.wallet.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {
}
