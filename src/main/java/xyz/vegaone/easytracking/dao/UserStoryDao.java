package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.UserStory;

/**
 * Dao interface for CRUD operations on UserStory entity
 */
@Service
public interface UserStoryDao {

    /**
     * Fetches the UserStory entity from the database based on its id
     *
     * @param id    the id of the UserStory
     * @return      the UserStory entity
     */
    UserStory getUserStory(Long id);

    /**
     * Creates a new record in the database with the UserStory details
     *
     * @param userStory the UserStory to be inserted in the database
     */
    void createUserStory(UserStory userStory);

    /**
     * Updates the UserStory
     *
     * @param userStory the UserStory to be updated
     */
    void updateUserStory(UserStory userStory);

    /**
     * Deletes the UserStory from the database
     *
     * @param userStory the UserStory to be deleted
     */
    void deleteUserStory(UserStory userStory);
}
