package xyz.vegaone.easytracking.epic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.easytracking.dto.Epic;
import xyz.vegaone.easytracking.dto.Project;
import xyz.vegaone.easytracking.service.EpicService;
import xyz.vegaone.easytracking.service.ProjectService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EpicServiceTest {

    @Autowired
    private EpicService epicService;

    @Autowired
    private ProjectService projectService;

    private final static String EPIC_TITLE = "EpicOne";
    private final static String EPIC_TITLE_TO_UPDATE = "EpicTwo";
    private final static String PROJECT_NAME = "ProjectOne";

    @Test
    public void createEpicTest() {
        //given/when
        Epic saveResult = buildAndSaveEpic();

        //then
        Assert.assertNotNull("There should have been one epic saved in the database", saveResult);
        Assert.assertEquals("The epic title should have matched", EPIC_TITLE, saveResult.getTitle());
    }

    @Test
    public void getEpicTest() {
        //given
        Epic saveResult = buildAndSaveEpic();

        //when
        Epic findResult = epicService.getEpic(saveResult.getId());

        //then
        Assert.assertNotNull("There should have been one epic saved in the database", saveResult);
        Assert.assertEquals("The epic title should have matched", EPIC_TITLE, findResult.getTitle());
    }

    @Test
    public void updateEpicTest() {
        //given
        Epic saveResult = buildAndSaveEpic();

        //when
        saveResult.setTitle(EPIC_TITLE_TO_UPDATE);
        Epic updatedEpic = epicService.updateEpic(saveResult);
        Epic findResult = epicService.getEpic(updatedEpic.getId());

        //then
        Assert.assertNotNull("There should have been one epic updated in the database.", findResult);
        Assert.assertEquals("The project title should have been changed", EPIC_TITLE_TO_UPDATE, findResult.getTitle());

    }

    @Test
    public void deleteEpicTest() {
        //given
        Epic saveResult = buildAndSaveEpic();

        //when
        epicService.deleteEpic(saveResult);
        Epic findResult = epicService.getEpic(saveResult.getId());

        // then
        Assert.assertNull("The project should have been removed from the database.", findResult);
    }

    public Epic buildAndSaveEpic(){
        Epic epic = new Epic();
        epic.setTitle(EPIC_TITLE);
        epic.setProject(buildAndSaveProject());

        return epicService.createEpic(epic);
    }

    public Project buildAndSaveProject(){
        Project project = new Project();
        project.setName(PROJECT_NAME);

        return projectService.createProject(project);
    }

}
