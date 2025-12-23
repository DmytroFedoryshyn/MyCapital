package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.fedoryshyn.MyCapital.dto.IncomeTransactionDto;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.income.IncomeTransaction;

@Mapper(
    componentModel = "spring",
    uses = {
        CashTransactionLineMapper.class,
        CurrencyAmountMapper.class,
        ReferenceMapper.class
    }
)
public interface IncomeTransactionMapper {

    @Mapping(target = "user", source = "userId", qualifiedByName = "userFromId")
    @Mapping(target = "wallet", source = "walletId", qualifiedByName = "walletFromId")
    @Mapping(target = "active", source = "active")

    @Mapping(target = "type", ignore = true)
    @Mapping(target = "operationType", ignore = true)
    @Mapping(target = "cashFlowRecords", ignore = true)
    IncomeTransaction toEntity(IncomeTransactionDto dto);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "walletId", source = "wallet.id")
    @Mapping(target = "active", source = "active")
    IncomeTransactionDto toDto(IncomeTransaction entity);
}
