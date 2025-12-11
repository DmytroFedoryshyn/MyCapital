package ua.fedoryshyn.MyCapital.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.fedoryshyn.MyCapital.dto.ProjectDto;
import ua.fedoryshyn.MyCapital.mapper.ProjectMapper;
import ua.fedoryshyn.MyCapital.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectController(ProjectService projectService,
                             ProjectMapper projectMapper) {
        this.projectService = projectService;
        this.projectMapper = projectMapper;
    }

    @PostMapping
    public ProjectDto create(@RequestBody ProjectDto dto) {
        return projectMapper.toDto(projectService.save(projectMapper.toEntity(dto)));
    }

    @GetMapping
    public List<ProjectDto> findAll() {
        return projectService.findAll()
                .stream()
                .map(projectMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ProjectDto findById(@PathVariable UUID id) {
        return projectMapper.toDto(projectService.findById(id));
    }

    @PutMapping("/{id}")
    public ProjectDto update(@PathVariable UUID id, @RequestBody ProjectDto dto) {
        dto.setId(id);
        return projectMapper.toDto(projectService.save(projectMapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        projectService.delete(id);
    }
}



