package xyz.vegaone.easytracking.service;

import xyz.vegaone.easytracking.dto.Epic;
import xyz.vegaone.easytracking.dto.Project;

public interface ProjectService {

    Project getProject(Long id);

    Project createProject(Project project);

    Project updateProject(Project project);

    void deleteProject(Project project);

    void removeEpic(Epic epic);
}
