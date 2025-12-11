package ua.fedoryshyn.MyCapital.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDto {
    private UUID id;
    private UUID userId;
    private String name;
    private Boolean isActive;
}



