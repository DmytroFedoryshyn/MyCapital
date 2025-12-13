package ua.fedoryshyn.MyCapital.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.CashTransaction;

public interface CashTransactionRepository extends JpaRepository<CashTransaction, UUID> {
}





