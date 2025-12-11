package ua.fedoryshyn.MyCapital.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.fedoryshyn.MyCapital.entity.project.Project;
import ua.fedoryshyn.MyCapital.repository.ProjectRepository;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(UUID id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Project not found: " + id));
    }

    public void delete(UUID id) {
        projectRepository.deleteById(id);
    }
}

