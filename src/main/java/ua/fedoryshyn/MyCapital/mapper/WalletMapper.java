package ua.fedoryshyn.MyCapital.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import ua.fedoryshyn.MyCapital.application.dto.WalletDto;
import ua.fedoryshyn.MyCapital.infrastructure.persistence.jpa.catalog.wallet.WalletEntity;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    WalletEntity toEntity(WalletDto walletDto);

    WalletDto toDto(WalletEntity wallet);

    List<WalletDto> toDtoList(List<WalletEntity> wallets);
}





