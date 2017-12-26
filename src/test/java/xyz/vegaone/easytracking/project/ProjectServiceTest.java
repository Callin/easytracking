package xyz.vegaone.easytracking.project;

import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.easytracking.dto.Project;
import xyz.vegaone.easytracking.repo.ProjectRepo;
import xyz.vegaone.easytracking.service.ProjectService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private Mapper mapper;

    private final static String PROJECT_NAME = "ProjectOne";
    private final static String PROJECT_NAME_TO_UPDATE = "ProjectTwo";

    @Test
    public void createProjectTest() {
        //given/when
        Project saveResult = buildAndSaveProject();

        //then
        Assert.assertNotNull("There should have been one project saved in the database", saveResult);
        Assert.assertEquals("The project title should have matched", PROJECT_NAME, saveResult.getName());
    }

    @Test
    public void getProjectTest() {
        //given
        Project saveResult = buildAndSaveProject();

        //when
        Project findResult = projectService.getProject(saveResult.getId());

        //then
        Assert.assertNotNull("There should have been one project saved in the database", saveResult);
        Assert.assertEquals("The project title should have matched", PROJECT_NAME, findResult.getName());
    }

    @Test
    public void updateProjectTest() {
        //given
        Project saveResult = buildAndSaveProject();

        //when
        saveResult.setName(PROJECT_NAME_TO_UPDATE);
        Project updatedProject = projectService.updateProject(saveResult);
        Project findResult = projectService.getProject(updatedProject.getId());

        //then
        Assert.assertNotNull("There should have been one project updated in the database.", findResult);
        Assert.assertEquals("The project title should have been changed", PROJECT_NAME_TO_UPDATE, findResult.getName());

    }

    @Test
    public void deleteProjectTest() {
        //given
        Project saveResult = buildAndSaveProject();

        //when
        projectService.deleteProject(saveResult);
        Project findResult = projectService.getProject(saveResult.getId());

        // then
        Assert.assertNull("The project should have been removed from the database.", findResult);
    }

    public Project buildAndSaveProject(){
        Project project = new Project();
        project.setName(PROJECT_NAME);

        return projectService.createProject(project);
    }

}
