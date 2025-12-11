package ua.fedoryshyn.MyCapital.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.income.IncomeTransaction;
import ua.fedoryshyn.MyCapital.repository.IncomeTransactionRepository;

@Service
public class IncomeTransactionService {

    private final IncomeTransactionRepository incomeTransactionRepository;

    @Autowired
    public IncomeTransactionService(IncomeTransactionRepository incomeTransactionRepository) {
        this.incomeTransactionRepository = incomeTransactionRepository;
    }

    public IncomeTransaction save(IncomeTransaction incomeTransaction) {
        return incomeTransactionRepository.save(incomeTransaction);
    }

    public List<IncomeTransaction> findAll() {
        return incomeTransactionRepository.findAll();
    }

    public IncomeTransaction findById(UUID id) {
        return incomeTransactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Income transaction not found: " + id));
    }

    public void delete(UUID id) {
        incomeTransactionRepository.deleteById(id);
    }
}

