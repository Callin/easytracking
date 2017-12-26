package xyz.vegaone.easytracking.bug;

import org.dozer.Mapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.easytracking.domain.EpicEntity;
import xyz.vegaone.easytracking.domain.FeatureEntity;
import xyz.vegaone.easytracking.domain.ProjectEntity;
import xyz.vegaone.easytracking.domain.UserStoryEntity;
import xyz.vegaone.easytracking.dto.Bug;
import xyz.vegaone.easytracking.dto.Epic;
import xyz.vegaone.easytracking.dto.Feature;
import xyz.vegaone.easytracking.dto.Project;
import xyz.vegaone.easytracking.dto.Sprint;
import xyz.vegaone.easytracking.dto.UserStory;
import xyz.vegaone.easytracking.repo.EpicRepo;
import xyz.vegaone.easytracking.repo.FeatureRepo;
import xyz.vegaone.easytracking.repo.ProjectRepo;
import xyz.vegaone.easytracking.repo.UserStoryRepo;
import xyz.vegaone.easytracking.service.BugService;
import xyz.vegaone.easytracking.service.UserService;
import xyz.vegaone.easytracking.service.UserStoryService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BugServiceTest {

    @Autowired
    private BugService bugService;

    @Autowired
    private UserStoryService userStoryService;

    @Autowired
    private UserStoryRepo userStoryRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private Mapper mapper;

    private final static String BUG_TITLE = "worm";
    private final static String BUG_TITLE_TO_UPDATE = "deadlyWorm";

    @Test
    public void createBugTest() {
        //given
        Bug saveResult = saveBug();

        //then
        Assert.assertNotNull("There should have been one bugEntity saved in the database", saveResult);
        Assert.assertEquals("The bugEntity title should have matched", BUG_TITLE, saveResult.getTitle());
    }

    @Test
    public void getBugTest() {
        //given
        Bug saveResult = saveBug();

        //when
        Bug findResult = bugService.getBug(saveResult.getId());

        //then
        Assert.assertNotNull("There should have been one bugEntity saved in the database.", findResult);
        Assert.assertEquals("The bugEntity title should have matched", BUG_TITLE, findResult.getTitle());
    }

    @Test
    public void updateUserTest() {
        //given
        Bug saveResult = saveBug();
        saveResult.setTitle(BUG_TITLE_TO_UPDATE);

        //when
        Bug updatedBug = bugService.updateBug(saveResult);
        Bug findResult = bugService.getBug(updatedBug.getId());

        //then
        Assert.assertNotNull("There should have been one bugEntity saved in the database.", findResult);
        Assert.assertNotEquals("The bugEntity title should have been changed", BUG_TITLE, findResult.getTitle());

    }

    @Test
    public void deleteBugTest() {
        //given
        Bug saveResult = saveBug();

        //when
        bugService.deleteBug(saveResult);
        Bug findResult = bugService.getBug(saveResult.getId());

        // then
        Assert.assertNull("The bug should have been removed from the database.", findResult);
    }

    public Bug saveBug() {
        Bug bug = new Bug();
        bug.setTitle(BUG_TITLE);

        UserStory userStory = new UserStory();
        userStory.setTitle("UserStory One");

        bug.setUserStory(userStoryService.createUserStory(userStory));
        return bugService.createBug(bug);
    }
//
//    public Project buildAndSaveProject(){
//        Project project = new Project();
//
//        project.setName("Project One");
//
//        return projectRepo.save(project);
//
//    }

}
