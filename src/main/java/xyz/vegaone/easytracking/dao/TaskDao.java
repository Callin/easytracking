package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.Task;

/**
 * Dao interface for CRUD operations on Task entity
 */
@Service
public interface TaskDao {

    /**
     * Fetches the task entity from the database based on its id
     *
     * @param id    the id of the task
     * @return      the task entity
     */
    Task getTask(Long id);

    /**
     * Creates a new record in the database with the task details
     *
     * @param task  the task to be inserted in the database
     */
    void createTask(Task task);

    /**
     * Updates the task
     *
     * @param task  the task to be updated
     */
    void updateTask(Task task);

    /**
     * Deletes the task from the database
     *
     * @param task  the task to be deleted
     */
    void deleteTask(Task task);
}
