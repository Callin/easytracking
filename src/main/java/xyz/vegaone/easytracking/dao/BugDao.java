package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.Bug;

/**
 * Dao interface for CRUD operations on Bug entity
 */
@Service
public interface BugDao {

    /**
     * Fetches the bug entity from the database based on its id
     *
     * @param id    the id of the bug
     * @return      the bug entity
     */
    Bug getBug(Long id);

    /**
     * Creates a new record in the database with the bug details
     *
     * @param bug   the bug to be inserted in the database
     */
    void createBug(Bug bug);

    /**
     * Updates the bug
     *
     * @param bug   the bug to be updated
     */
    void updateBug(Bug bug);

    /**
     * Deletes the bug from the database
     *
     * @param bug   the bug to be deleted
     */
    void deleteBug(Bug bug);
}
