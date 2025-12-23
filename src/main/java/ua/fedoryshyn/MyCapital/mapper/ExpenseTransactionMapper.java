package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.fedoryshyn.MyCapital.dto.ExpenseTransactionDto;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.expense.ExpenseTransaction;

@Mapper(
    componentModel = "spring",
    uses = {
        CashTransactionLineMapper.class,
        CurrencyAmountMapper.class,
        ReferenceMapper.class
    }
)
public interface ExpenseTransactionMapper {

    @Mapping(target = "user", source = "userId", qualifiedByName = "userFromId")
    @Mapping(target = "wallet", source = "walletId", qualifiedByName = "walletFromId")
    @Mapping(target = "active", source = "active")

    @Mapping(target = "type", ignore = true)
    @Mapping(target = "operationType", ignore = true)
    @Mapping(target = "cashFlowRecords", ignore = true)
    ExpenseTransaction toEntity(ExpenseTransactionDto dto);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "walletId", source = "wallet.id")
    @Mapping(target = "active", source = "active")
    ExpenseTransactionDto toDto(ExpenseTransaction entity);
}
