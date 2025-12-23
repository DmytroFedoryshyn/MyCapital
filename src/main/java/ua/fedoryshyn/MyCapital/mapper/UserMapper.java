package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import ua.fedoryshyn.MyCapital.dto.UserDto;
import ua.fedoryshyn.MyCapital.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto dto);

    UserDto toDto(User entity);
}






