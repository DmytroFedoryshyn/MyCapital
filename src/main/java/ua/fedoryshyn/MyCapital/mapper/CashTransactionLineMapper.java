package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.fedoryshyn.MyCapital.application.dto.CashTransactionLineDto;
import ua.fedoryshyn.MyCapital.domain.transaction.cash.CashTransactionLine;
import ua.fedoryshyn.MyCapital.domain.transaction.cash.expense.ExpenseTransactionLine;
import ua.fedoryshyn.MyCapital.domain.transaction.cash.income.IncomeTransactionLine;

@Mapper(
    componentModel = "spring",
    uses = {
        ReferenceMapper.class,
        CurrencyAmountMapper.class
    }
)
public interface CashTransactionLineMapper {

    @Mapping(target = "category", source = "categoryId", qualifiedByName = "categoryFromId")
    CashTransactionLine toEntity(CashTransactionLineDto dto);

    @Mapping(target = "category", source = "categoryId", qualifiedByName = "categoryFromId")
    IncomeTransactionLine toIncomeEntity(CashTransactionLineDto dto);

    @Mapping(target = "category", source = "categoryId", qualifiedByName = "categoryFromId")
    ExpenseTransactionLine toExpenseEntity(CashTransactionLineDto dto);

    @Mapping(target = "categoryId", source = "category.id")
    CashTransactionLineDto toDto(CashTransactionLine entity);
}
