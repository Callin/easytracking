package xyz.vegaone.easytracking.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.easytracking.dto.User;
import xyz.vegaone.easytracking.service.UserService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserEntityTest {

    @Autowired
    private UserService userService;

    private final static String USER_NAME = "Johny";
    private final static String USER_NAME_TO_UPDATE = "Cash";

    @Test
    public void createUserTest() {
        // given
        User saveResult = saveUser();

        // then
        Assert.assertNotNull("There should have been one userEntity saved in the database.", saveResult);
        Assert.assertEquals("The userEntity name should have matched", USER_NAME, saveResult.getName());

    }

    @Test
    public void getUserTest() {
        // given
        User saveResult = saveUser();

        // when
        User findResult = userService.getUser(saveResult.getId());

        // then
        Assert.assertNotNull("There should have been one userEntity saved in the database.", findResult);
        Assert.assertEquals("The userEntity name should have matched", USER_NAME, findResult.getName());

    }

    @Test
    public void updateUserTest() {
        // given
        User saveResult = saveUser();
        saveResult.setName(USER_NAME_TO_UPDATE);

        // when
        User updatedUser = userService.updateUser(saveResult);
        User findResult = userService.getUser(updatedUser.getId());

        // then
        Assert.assertNotNull("There should have been one userEntity saved in the database.", findResult);
        Assert.assertNotEquals("The userEntity name should have been changed", USER_NAME, findResult.getName());

    }

    @Test
    public void deleteUserTest() {
        // given
        User saveResult = saveUser();

        // when
        userService.deleteUser(saveResult);
        User findResult = userService.getUser(saveResult.getId());

        // then
        Assert.assertNull("The user should have been removed from the database.", findResult);
    }

    public User saveUser() {
        User user = new User();
        user.setName(USER_NAME);
        return userService.createUser(user);
    }
}

