package ua.fedoryshyn.MyCapital.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import ua.fedoryshyn.MyCapital.entity.OperationType;

@Getter
@Setter
public class CategoryDto {
    private UUID id;
    private String name;
    private OperationType operationType;
    private UUID userId;
    private Boolean isActive;
}



