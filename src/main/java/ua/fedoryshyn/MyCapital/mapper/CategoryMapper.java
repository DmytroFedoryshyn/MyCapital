package ua.fedoryshyn.MyCapital.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ua.fedoryshyn.MyCapital.dto.CategoryDto;
import ua.fedoryshyn.MyCapital.entity.Category;
import ua.fedoryshyn.MyCapital.entity.User;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "user", source = "userId", qualifiedByName = "userFromId")
    Category toEntity(CategoryDto dto);

    @Mapping(target = "userId", source = "user.id")
    CategoryDto toDto(Category entity);

    @Named("userFromId")
    default User userFromId(java.util.UUID id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }
}



