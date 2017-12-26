package xyz.vegaone.easytracking.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.ProjectEntity;
import xyz.vegaone.easytracking.dto.Epic;
import xyz.vegaone.easytracking.dto.Project;
import xyz.vegaone.easytracking.repo.ProjectRepo;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepo projectRepo;

    private final Mapper mapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepo projectRepo, Mapper mapper) {
        this.projectRepo = projectRepo;
        this.mapper = mapper;
    }

    @Override
    public Project getProject(Long id) {
        Optional findResult = projectRepo.findById(id);

        ProjectEntity projectEntity;
        if (findResult.isPresent()) {
            projectEntity = (ProjectEntity) findResult.get();
            return mapper.map(projectEntity, Project.class);
        } else {
            return null;
        }
    }

    @Override
    public Project createProject(Project project) {
        ProjectEntity projectEntity = mapper.map(project, ProjectEntity.class);

        ProjectEntity savedProjectEntity = projectRepo.save(projectEntity);

        return mapper.map(savedProjectEntity, Project.class);
    }

    @Override
    public Project updateProject(Project project) {
        ProjectEntity projectEntity = mapper.map(project, ProjectEntity.class);

        ProjectEntity savedProjectEntity = projectRepo.save(projectEntity);

        return mapper.map(savedProjectEntity, Project.class);
    }

    @Override
    public void deleteProject(Project project) {
        ProjectEntity projectEntity = mapper.map(project, ProjectEntity.class);

        projectRepo.delete(projectEntity);
    }

    @Override
    public void removeEpic(Epic epic) {
        Project project = getProject(epic.getProject().getId());

        if (project != null) {
            project.getEpicList().remove(epic);
        }
    }
}
