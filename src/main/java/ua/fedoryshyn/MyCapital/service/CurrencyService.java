package ua.fedoryshyn.MyCapital.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedoryshyn.MyCapital.entity.Currency;
import ua.fedoryshyn.MyCapital.repository.CurrencyRepository;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public Currency save(Currency currency) {
        return currencyRepository.save(currency);
    }

    public List<Currency> findAll() {
        return currencyRepository.findAll();
    }

    public Currency findById(UUID id) {
        return currencyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Currency not found: " + id));
    }

    public void delete(UUID id) {
        currencyRepository.deleteById(id);
    }
}

