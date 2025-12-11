package ua.fedoryshyn.MyCapital.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.income.IncomeTransaction;

public interface IncomeTransactionRepository extends JpaRepository<IncomeTransaction, UUID> {
}



