package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Service;
import xyz.vegaone.easytracking.domain.Feature;

/**
 * Dao interface for CRUD operations on Feature entity
 */
@Service
public interface FeatureDao {

    /**
     * Fetches the feature entity from the database based on its id
     *
     * @param id    the id of the feature
     * @return      the feature entity
     */
    Feature getFeature(Long id);

    /**
     * Creates a new record in the database with the feature details
     *
     * @param feature   the feature to be inserted in the database
     */
    void createFeature(Feature feature);

    /**
     * Updates the feature
     *
     * @param feature   the feature to be updated
     */
    void updateFeature(Feature feature);

    /**
     * Deletes the feature from the database
     *
     * @param feature   the feature to be deleted
     */
    void deleteFeature(Feature feature);
}
