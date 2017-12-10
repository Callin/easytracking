package xyz.vegaone.easytracking.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.vegaone.easytracking.dao.UserDao;
import xyz.vegaone.easytracking.domain.User;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void createUserTest(){
        // given
        User user = new User();

        user.setName("Johny");

        // when
        userDao.createUser(user);

        // then
    }
}
