package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import ua.fedoryshyn.MyCapital.dto.CurrencyClassifierDto;
import ua.fedoryshyn.MyCapital.entity.CurrencyClassifier;

@Mapper(componentModel = "spring")
public interface CurrencyClassifierMapper {

    CurrencyClassifier toEntity(CurrencyClassifierDto dto);

    CurrencyClassifierDto toDto(CurrencyClassifier entity);
}





