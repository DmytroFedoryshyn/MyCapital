package ua.fedoryshyn.MyCapital.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedoryshyn.MyCapital.entity.transaction.Transaction;
import ua.fedoryshyn.MyCapital.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(UUID id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found: " + id));
    }

    public void delete(UUID id) {
        transactionRepository.deleteById(id);
    }
}

