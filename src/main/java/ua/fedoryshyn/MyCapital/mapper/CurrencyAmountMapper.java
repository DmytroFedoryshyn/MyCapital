package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ua.fedoryshyn.MyCapital.dto.CurrencyAmountDto;
import ua.fedoryshyn.MyCapital.entity.Currency;
import ua.fedoryshyn.MyCapital.entity.CurrencyAmount;

@Mapper(
    componentModel = "spring",
    uses = ReferenceMapper.class
)
public interface CurrencyAmountMapper {

    @Mapping(target = "currency", source = "currencyId", qualifiedByName = "currencyFromId")
    CurrencyAmount toEntity(CurrencyAmountDto dto);

    @Mapping(target = "currencyId", source = "currency.id")
    CurrencyAmountDto toDto(CurrencyAmount entity);
}
