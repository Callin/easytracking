package xyz.vegaone.easytracking.user;

import org.junit.Assert;
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

    @Test
    public void createUserTest(){
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
}
