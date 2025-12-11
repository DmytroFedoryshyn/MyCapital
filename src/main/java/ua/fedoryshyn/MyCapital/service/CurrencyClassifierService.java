package ua.fedoryshyn.MyCapital.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedoryshyn.MyCapital.entity.CurrencyClassifier;
import ua.fedoryshyn.MyCapital.repository.CurrencyClassifierRepository;

@Service
public class CurrencyClassifierService {

    private final CurrencyClassifierRepository classifierRepository;

    @Autowired
    public CurrencyClassifierService(CurrencyClassifierRepository classifierRepository) {
        this.classifierRepository = classifierRepository;
    }

    public CurrencyClassifier save(CurrencyClassifier classifier) {
        return classifierRepository.save(classifier);
    }

    public List<CurrencyClassifier> findAll() {
        return classifierRepository.findAll();
    }

    public CurrencyClassifier findById(String alphaCode) {
        return classifierRepository.findById(alphaCode)
                .orElseThrow(() -> new EntityNotFoundException("Currency classifier not found: " + alphaCode));
    }

    public void delete(String alphaCode) {
        classifierRepository.deleteById(alphaCode);
    }
}

