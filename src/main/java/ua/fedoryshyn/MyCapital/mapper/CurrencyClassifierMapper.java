package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import ua.fedoryshyn.MyCapital.application.dto.CurrencyClassifierDto;
import ua.fedoryshyn.MyCapital.domain.classifier.currency.CurrencyClassifier;

@Mapper(componentModel = "spring")
public interface CurrencyClassifierMapper {

    CurrencyClassifier toEntity(CurrencyClassifierDto dto);

    CurrencyClassifierDto toDto(CurrencyClassifier entity);
}







