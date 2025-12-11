package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ua.fedoryshyn.MyCapital.dto.IncomeTransactionDto;
import ua.fedoryshyn.MyCapital.entity.User;
import ua.fedoryshyn.MyCapital.entity.Wallet;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.income.IncomeTransaction;

@Mapper(componentModel = "spring", uses = {CurrencyAmountMapper.class, CashTransactionLineMapper.class})
public interface IncomeTransactionMapper {

    @Mapping(target = "user", source = "userId", qualifiedByName = "userFromId")
    @Mapping(target = "wallet", source = "walletId", qualifiedByName = "walletFromId")
    IncomeTransaction toEntity(IncomeTransactionDto dto);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "walletId", source = "wallet.id")
    IncomeTransactionDto toDto(IncomeTransaction entity);

    @Named("userFromId")
    default User userFromId(java.util.UUID id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }

    @Named("walletFromId")
    default Wallet walletFromId(java.util.UUID id) {
        if (id == null) {
            return null;
        }
        Wallet wallet = new Wallet();
        wallet.setId(id);
        return wallet;
    }
}



