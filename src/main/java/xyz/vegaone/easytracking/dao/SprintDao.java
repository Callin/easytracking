package xyz.vegaone.easytracking.dao;

import xyz.vegaone.easytracking.domain.Sprint;

/**
 * Dao interface for CRUD operations on Sprint entity
 */

public interface SprintDao {
    /**
     * Fetches the sprint entity from hte database based on its id
     *
     * @param id    the id of the sprint
     * @return      the sprint entity
     */
    Sprint getSprint(Long id);

    /**
     * Creates a new record in the database with the sprint details
     *
     * @param sprint  the sprint to be inserted in the database
     */
    void createSprint(Sprint sprint);

    /**
     * Updates the sprint
     *
     * @param sprint to be updated
     */
    void updateSprint(Sprint sprint);

    /**
     * Deletes the sprint from the database
     * @param sprint  to be deleted
     */
    void deleteSprint(Sprint sprint);
}
