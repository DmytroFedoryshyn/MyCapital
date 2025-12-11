package ua.fedoryshyn.MyCapital.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import ua.fedoryshyn.MyCapital.dto.WalletDto;
import ua.fedoryshyn.MyCapital.entity.Wallet;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    Wallet toEntity(WalletDto walletDto);

    WalletDto toDto(Wallet wallet);

    List<WalletDto> toDtoList(List<Wallet> wallets);
}





