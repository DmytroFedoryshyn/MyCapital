package ua.fedoryshyn.MyCapital.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.fedoryshyn.MyCapital.dto.WalletDto;
import ua.fedoryshyn.MyCapital.service.WalletService;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    private final WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping
    public WalletDto save(@RequestBody WalletDto walletDto) {
        return walletService.createWallet(walletDto);
    }

    @GetMapping
    public List<WalletDto> getAll() {
        return walletService.getAllWallets();
    }

    @GetMapping("/{id}")
    public WalletDto getById(@PathVariable UUID id) {
        return walletService.getWallet(id);
    }

    @PutMapping("/{id}")
    public WalletDto update(@PathVariable UUID id, @RequestBody WalletDto walletDto) {
        return walletService.updateWallet(id, walletDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        walletService.deleteWallet(id);
    }
}
