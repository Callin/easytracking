package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.Epic;

/**
 * Dao interface for CRUD operations on epic entity
 */
@Service
public interface EpicDao {

    /**
     * Fetches the epic entity from the database based on its id
     *
     * @param id    the id of the epic
     * @return      the epic entity
     */
    Epic getEpic(Long id);

    /**
     * Creates a new record in the database with the epic details
     *
     * @param epic  the epic to be inserted to the database
     */
    void createEpic(Epic epic);

    /**
     * Updates the epic
     *
     * @param epic  the epic to be updated
     */
    void updateEpic(Epic epic);

    /**
     * Deletes the epic from the database
     *
     * @param epic  the epic to be deleted
     */
    void deleteEpic(Epic epic);
}
