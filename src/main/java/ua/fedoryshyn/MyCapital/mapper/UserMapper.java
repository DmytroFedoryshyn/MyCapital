package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import ua.fedoryshyn.MyCapital.application.dto.UserDto;
import ua.fedoryshyn.MyCapital.domain.user.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User entity);
}







