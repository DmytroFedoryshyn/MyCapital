package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.fedoryshyn.MyCapital.domain.transaction.cash.income.IncomeTransaction;

public interface IncomeTransactionRepository extends JpaRepository<IncomeTransaction, UUID> {
}







