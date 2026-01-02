package ua.fedoryshyn.MyCapital.mapper;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ua.fedoryshyn.MyCapital.domain.catalog.user.User;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog.wallet.WalletEntity;
import ua.fedoryshyn.MyCapital.domain.catalog.category.Category;
import ua.fedoryshyn.MyCapital.domain.catalog.currency.Currency;

@Mapper(componentModel = "spring")
public interface ReferenceMapper {

    @Named("userFromId")
    default User userFromId(UUID id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }

    @Named("walletFromId")
    default WalletEntity walletFromId(UUID id) {
        if (id == null) {
            return null;
        }
        WalletEntity wallet = new WalletEntity();
        wallet.setId(id);
        return wallet;
    }

    @Named("categoryFromId")
    default Category categoryFromId(UUID id) {
        if (id == null) {
            return null;
        }
        Category category = new Category();
        category.setId(id);
        return category;
    }

    @Named("currencyFromId")
    default Currency currencyFromId(UUID id) {
        if (id == null) {
            return null;
        }
        Currency currency = new Currency();
        currency.setId(id);
        return currency;
    }
}
