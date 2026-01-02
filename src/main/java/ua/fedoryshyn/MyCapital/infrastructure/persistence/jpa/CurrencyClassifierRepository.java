package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.fedoryshyn.MyCapital.domain.classifier.currency.CurrencyClassifier;

public interface CurrencyClassifierRepository extends JpaRepository<CurrencyClassifier, String> {
}







