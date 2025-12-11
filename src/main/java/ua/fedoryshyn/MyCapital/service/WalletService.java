package ua.fedoryshyn.MyCapital.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedoryshyn.MyCapital.dto.WalletDto;
import ua.fedoryshyn.MyCapital.entity.Wallet;
import ua.fedoryshyn.MyCapital.mapper.WalletMapper;
import ua.fedoryshyn.MyCapital.repository.WalletRepository;

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
        Wallet walletToSave = walletMapper.toEntity(walletDto);
        Wallet savedWallet = walletRepository.save(walletToSave);
        return walletMapper.toDto(savedWallet);
    }

    public List<WalletDto> getAllWallets() {
        return walletMapper.toDtoList(walletRepository.findAll());
    }

    public WalletDto getWallet(UUID id) {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Wallet not found: " + id));
        return walletMapper.toDto(wallet);
    }

    public WalletDto updateWallet(UUID id, WalletDto walletDto) {
        if (!walletRepository.existsById(id)) {
            throw new EntityNotFoundException("Wallet not found: " + id);
        }
        Wallet walletToSave = walletMapper.toEntity(walletDto);
        walletToSave.setId(id);
        Wallet savedWallet = walletRepository.save(walletToSave);
        return walletMapper.toDto(savedWallet);
    }

    public void deleteWallet(UUID id) {
        walletRepository.deleteById(id);
    }
}
