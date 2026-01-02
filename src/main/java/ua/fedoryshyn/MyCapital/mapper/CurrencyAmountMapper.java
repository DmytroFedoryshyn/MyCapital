package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.fedoryshyn.MyCapital.application.dto.CurrencyAmountDto;
import ua.fedoryshyn.MyCapital.domain.valueObject.CurrencyAmount;

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

