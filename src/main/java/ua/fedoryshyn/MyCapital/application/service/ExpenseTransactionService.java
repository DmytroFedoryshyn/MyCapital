package ua.fedoryshyn.MyCapital.application.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedoryshyn.MyCapital.domain.transaction.cash.expense.ExpenseTransaction;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.ExpenseTransactionRepository;

@Service
public class ExpenseTransactionService {

    private final ExpenseTransactionRepository expenseTransactionRepository;

    @Autowired
    public ExpenseTransactionService(ExpenseTransactionRepository expenseTransactionRepository) {
        this.expenseTransactionRepository = expenseTransactionRepository;
    }

    public ExpenseTransaction save(ExpenseTransaction expenseTransaction) {
        return expenseTransactionRepository.save(expenseTransaction);
    }

    public List<ExpenseTransaction> findAll() {
        return expenseTransactionRepository.findAll();
    }

    public ExpenseTransaction findById(UUID id) {
        return expenseTransactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Expense transaction not found: " + id));
    }

    public void delete(UUID id) {
        expenseTransactionRepository.deleteById(id);
    }
}

