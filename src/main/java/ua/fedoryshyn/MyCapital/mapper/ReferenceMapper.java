package ua.fedoryshyn.MyCapital.mapper;

import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ua.fedoryshyn.MyCapital.entity.User;
import ua.fedoryshyn.MyCapital.entity.Wallet;
import ua.fedoryshyn.MyCapital.entity.Category;
import ua.fedoryshyn.MyCapital.entity.Currency;

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
    default Wallet walletFromId(UUID id) {
        if (id == null) {
            return null;
        }
        Wallet wallet = new Wallet();
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
