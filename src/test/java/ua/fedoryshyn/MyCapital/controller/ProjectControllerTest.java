package ua.fedoryshyn.MyCapital.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.fedoryshyn.MyCapital.dto.ProjectDto;
import ua.fedoryshyn.MyCapital.entity.project.Project;
import ua.fedoryshyn.MyCapital.mapper.ProjectMapper;
import ua.fedoryshyn.MyCapital.service.ProjectService;

@WebMvcTest(ProjectController.class)
class ProjectControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProjectService projectService;

    @MockBean
    private ProjectMapper projectMapper;

    @Test
    void createProject() throws Exception {
        ProjectDto request = new ProjectDto();
        request.setName("Trip");
        request.setUserId(UUID.randomUUID());

        Project entity = new Project();
        ProjectDto response = new ProjectDto();
        response.setId(UUID.randomUUID());
        response.setName("Trip");
        response.setUserId(request.getUserId());
        response.setIsActive(true);

        when(projectMapper.toEntity(request)).thenReturn(entity);
        when(projectService.save(entity)).thenReturn(entity);
        when(projectMapper.toDto(entity)).thenReturn(response);

        mockMvc.perform(post("/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Trip"));
    }

    @Test
    void getAllProjects() throws Exception {
        Project entity = new Project();
        ProjectDto dto = new ProjectDto();
        dto.setId(UUID.randomUUID());
        dto.setName("Home");
        dto.setUserId(UUID.randomUUID());

        when(projectService.findAll()).thenReturn(List.of(entity));
        when(projectMapper.toDto(entity)).thenReturn(dto);

        mockMvc.perform(get("/projects"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Home"));
    }
}



