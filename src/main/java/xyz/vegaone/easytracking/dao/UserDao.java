package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.User;

/**
 * Dao interface for CRUD operations on User entity
 */
@Service
public interface UserDao {
    /**
     * Fetches the user entity from hte database based on its id
     *
     * @param id    the id of the user
     * @return      the user entity
     */
    User getUser(Long id);

    /**
     * Creates a new record in the database with the user details
     *
     * @param user  the user to be inserted in the database
     */
    void createUser(User user);

    /**
     * Updates the user
     *
     * @param user to be updated
     */
    void updateUser(User user);

    /**
     * Deletes the user from the database
     * @param user  to be deleted
     */
    void deleteUser(User user);
}
