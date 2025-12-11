package ua.fedoryshyn.MyCapital.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.fedoryshyn.MyCapital.entity.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}



