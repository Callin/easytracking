package xyz.vegaone.easytracking.userstory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.easytracking.dto.UserStory;
import xyz.vegaone.easytracking.service.UserStoryService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserStoryServiceTest {

    @Autowired
    private UserStoryService userStoryService;

    private final static String USERSTORY_TITLE = "userStory";
    private final static String USERSTORY_TITLE_TO_UPDATE = "storyUpdated";

    @Test
    public void createUserStoryTest() {
        //given
        UserStory saveResult = saveUserStory();

        //then
        Assert.assertNotNull("There should have been one userStory saved in the database", saveResult);
        Assert.assertEquals("The userStory title should have matched", USERSTORY_TITLE, saveResult.getTitle());

    }

    @Test
    public void getUserStoryTest() {
        //given
        UserStory saveResult = saveUserStory();

        //when
        UserStory findResult = userStoryService.getUserStory(saveResult.getId());

        //then
        Assert.assertNotNull("There should have been one userStory saved in the database", findResult);
        Assert.assertEquals("The userStory title should have matched", USERSTORY_TITLE, findResult.getTitle());

    }

    @Test
    public void updateUserStoryTest() {
        //given
        UserStory saveResult = saveUserStory();
        saveResult.setTitle(USERSTORY_TITLE_TO_UPDATE);

        //when
        UserStory updatedUserStory = userStoryService.updateUserStory(saveResult);
        UserStory findResult = userStoryService.getUserStory(updatedUserStory.getId());

        //then
        Assert.assertNotNull("There should have been one UserStoryEntity saved in the database", findResult);
        Assert.assertNotEquals("The userStory title should have been changed", USERSTORY_TITLE, findResult.getTitle());

    }

    @Test
    public void deleteUserStoryTest() {
        //given
        UserStory saveResult = saveUserStory();

        //when
        userStoryService.deleteUserStory(saveResult);
        UserStory findResult = userStoryService.getUserStory(saveResult.getId());

        //then
        Assert.assertNull("The userStory should have been removed from the database", findResult);
    }

    public UserStory saveUserStory() {
        UserStory userStory = new UserStory();
        userStory.setTitle(USERSTORY_TITLE);
        return userStoryService.createUserStory(userStory);
    }
}
