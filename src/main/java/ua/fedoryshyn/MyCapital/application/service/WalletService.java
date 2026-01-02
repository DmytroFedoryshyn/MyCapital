package ua.fedoryshyn.MyCapital.application.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedoryshyn.MyCapital.application.dto.WalletDto;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog.wallet.WalletEntity;
import ua.fedoryshyn.MyCapital.mapper.WalletMapper;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog.wallet.WalletRepository;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    @Autowired
    public WalletService(WalletRepository walletRepository,
                         WalletMapper walletMapper) {
        this.walletRepository = walletRepository;
        this.walletMapper = walletMapper;
    }

    public WalletDto createWallet(WalletDto walletDto) {
        WalletEntity walletToSave = walletMapper.toEntity(walletDto);
        WalletEntity savedWallet = walletRepository.save(walletToSave);
        return walletMapper.toDto(savedWallet);
    }

    public List<WalletDto> getAllWallets() {
        return walletMapper.toDtoList(walletRepository.findAll());
    }

    public WalletDto getWallet(UUID id) {
        WalletEntity wallet = walletRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("WalletEntity not found: " + id));
        return walletMapper.toDto(wallet);
    }

    public WalletDto updateWallet(UUID id, WalletDto walletDto) {
        if (!walletRepository.existsById(id)) {
            throw new EntityNotFoundException("WalletEntity not found: " + id);
        }
        WalletEntity walletToSave = walletMapper.toEntity(walletDto);
        walletToSave.setId(id);
        WalletEntity savedWallet = walletRepository.save(walletToSave);
        return walletMapper.toDto(savedWallet);
    }

    public void deleteWallet(UUID id) {
        walletRepository.deleteById(id);
    }
}
