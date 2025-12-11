package ua.fedoryshyn.MyCapital.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.fedoryshyn.MyCapital.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, UUID> {
}
