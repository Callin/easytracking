package xyz.vegaone.easytracking.sprint;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.easytracking.dto.Epic;
import xyz.vegaone.easytracking.dto.Project;
import xyz.vegaone.easytracking.dto.Sprint;
import xyz.vegaone.easytracking.service.ProjectService;
import xyz.vegaone.easytracking.service.SprintService;

import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SprintServiceTest {

    @Autowired
    private SprintService sprintService;

    @Autowired
    private ProjectService projectService;

    private final static int NUMBER_OF_DAYS = 1;
    private final static int NUMBER_OF_DAYS_UPDATE = 1;
    private final static String PROJECT_NAME = "ProjectOne";

    @Test
    public void createSprintTest() {
        //given/when
        Sprint saveResult = buildAndSaveSprint();

        //then
        Assert.assertNotNull("There should have been one sprint saved in the database", saveResult);
        Assert.assertEquals("The sprint number of days should have matched", NUMBER_OF_DAYS, saveResult.getNumberOfDays());
    }

    @Test
    public void getEpicTest() {
        //given
        Sprint saveResult = buildAndSaveSprint();

        //when
        Sprint findResult = sprintService.getSprint(saveResult.getId());

        //then
        Assert.assertNotNull("There should have been one sprint saved in the database", saveResult);
        Assert.assertEquals("The sprint number of days should have matched", NUMBER_OF_DAYS, findResult.getNumberOfDays());
    }

    @Test
    public void updateEpicTest() {
        //given
        Sprint saveResult = buildAndSaveSprint();

        //when
        saveResult.setNumberOfDays(NUMBER_OF_DAYS_UPDATE);
        Sprint updatedEpic = sprintService.updateSprint(saveResult);
        Sprint findResult = sprintService.getSprint(updatedEpic.getId());

        //then
        Assert.assertNotNull("There should have been one sprint updated in the database.", findResult);
        Assert.assertEquals("The project title should have been changed", NUMBER_OF_DAYS_UPDATE, findResult.getNumberOfDays());

    }

//    @Test
//    public void deleteEpicTest() {
//        //given
//        Epic saveResult = buildAndSaveSprint();
//
//        //when
//        sprintService.deleteEpic(saveResult);
//        Epic findResult = sprintService.getEpic(saveResult.getId());
//
//        // then
//        Assert.assertNull("The project should have been removed from the database.", findResult);
//    }

    public Sprint buildAndSaveSprint(){
        Sprint sprint = new Sprint();
        sprint.setStartDate(new Date());
        sprint.setEndDate(new Date());
        sprint.setNumberOfDays(NUMBER_OF_DAYS);

        sprint.setProject(buildAndSaveProject());

        return sprintService.createSprint(sprint);
    }

    public Project buildAndSaveProject(){
        Project project = new Project();
        project.setName(PROJECT_NAME);

        return projectService.createProject(project);
    }

}
