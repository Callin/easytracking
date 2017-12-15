package xyz.vegaone.easytracking.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.easytracking.dao.UserDao;
import xyz.vegaone.easytracking.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserDao userDao;

    @PersistenceContext
    private EntityManager em;

    public final static String USER_NAME = "Johny";
    public final static Long USER_ID = 1L;
    public final static String UPDATED_USER_NAME = "Bravo";
    public final static Long UPDATED_USER_ID = 2L;

    @Before
    public void setUp() {
        User testUser = new User();
        testUser.setName(USER_NAME);
        testUser.setId(USER_ID);
        userDao.createUser(testUser);
    }

    @Test
    public void createUserTest() {
        // given
        User user = new User();

        user.setName(USER_NAME);
        user.setId(USER_ID);

        // when
        userDao.createUser(user);

        // then
        User savedUser = em.find(User.class, USER_ID);
        Assert.assertNotNull("There should have been one user saved in the database.", savedUser);
        Assert.assertEquals("The user id should have matched", USER_ID, savedUser.getId());
        Assert.assertEquals("The user name should have matched", USER_NAME, savedUser.getName());

    }

    @Test
    public void getUserTest() {

        User returnedUser = em.find(User.class, USER_ID);
        Assert.assertNotNull("There should have been one user saved in the database.", returnedUser);
        Assert.assertEquals("The user id should have matched", USER_ID, returnedUser.getId());
        Assert.assertEquals("The user name should have matched", USER_NAME, returnedUser.getName());
    }

    @Test
    public void updateUser() {

        User returnedUser = em.find(User.class, USER_ID);
        returnedUser.setName(UPDATED_USER_NAME);
        returnedUser.setId(UPDATED_USER_ID);
        userDao.updateUser(returnedUser);
        Assert.assertNotNull("There should have been one user saved in the database.", returnedUser);
        Assert.assertEquals("The user id should have matched", UPDATED_USER_ID, returnedUser.getId());
        Assert.assertEquals("The user name should have matched", UPDATED_USER_NAME, returnedUser.getName());
    }

    @Test
    public void deleteUser() {

        User returnedUser = em.find(User.class, USER_ID);
        userDao.deleteUser(returnedUser);
        returnedUser = em.find(User.class, USER_ID);
        Assert.assertNull("We should have no user here", returnedUser);
    }
}
