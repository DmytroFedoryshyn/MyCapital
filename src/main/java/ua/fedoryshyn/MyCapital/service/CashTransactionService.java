package ua.fedoryshyn.MyCapital.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.CashTransaction;
import ua.fedoryshyn.MyCapital.repository.CashTransactionRepository;

@Service
public class CashTransactionService {

    private final CashTransactionRepository cashTransactionRepository;

    @Autowired
    public CashTransactionService(CashTransactionRepository cashTransactionRepository) {
        this.cashTransactionRepository = cashTransactionRepository;
    }

    public CashTransaction save(CashTransaction cashTransaction) {
        return cashTransactionRepository.save(cashTransaction);
    }

    public List<CashTransaction> findAll() {
        return cashTransactionRepository.findAll();
    }

    public CashTransaction findById(UUID id) {
        return cashTransactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cash transaction not found: " + id));
    }

    public void delete(UUID id) {
        cashTransactionRepository.deleteById(id);
    }
}

