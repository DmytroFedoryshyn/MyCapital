package ua.fedoryshyn.MyCapital.application.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog.wallet.Wallet;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.WalletRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository repository;

    public Wallet createWallet(Wallet wallet) {
        return repository.save(wallet);
    }

    public List<Wallet> getAllWallets() {
        return repository.findAll();
    }

    public Wallet getById(UUID id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Wallet not found: " + id));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}