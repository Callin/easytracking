package xyz.vegaone.easytracking.dao;

import xyz.vegaone.easytracking.domain.Project;

/**
 * Dao interface for CRUD operations on Project entity
 */

public interface ProjectDao {
    /**
     * Fetches the project entity from hte database based on its id
     *
     * @param id    the id of the project
     * @return      the project entity
     */
    Project getProject(Long id);

    /**
     * Creates a new record in the database with the project details
     *
     * @param project  the project to be inserted in the database
     */
    void createProject(Project project);

    /**
     * Updates the project
     *
     * @param project to be updated
     */
    void updateProject(Project project);

    /**
     * Deletes the project from the database
     * @param project  to be deleted
     */
    void deleteProject(Project project);
}
