package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ua.fedoryshyn.MyCapital.dto.CashTransactionLineDto;
import ua.fedoryshyn.MyCapital.entity.Category;
import ua.fedoryshyn.MyCapital.entity.transaction.cash.CashTransactionLine;

@Mapper(componentModel = "spring", uses = CurrencyAmountMapper.class)
public interface CashTransactionLineMapper {

    @Mapping(target = "category", source = "categoryId", qualifiedByName = "categoryFromId")
    CashTransactionLine toEntity(CashTransactionLineDto dto);

    @Mapping(target = "categoryId", source = "category.id")
    CashTransactionLineDto toDto(CashTransactionLine entity);

    @Named("categoryFromId")
    default Category categoryFromId(java.util.UUID id) {
        if (id == null) {
            return null;
        }
        Category category = new Category();
        category.setId(id);
        return category;
    }
}





