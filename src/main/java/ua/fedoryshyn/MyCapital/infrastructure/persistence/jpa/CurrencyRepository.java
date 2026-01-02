package ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.fedoryshyn.MyCapital.domain.catalog.currency.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, UUID> {
}







