package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.Feature;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class FeatureDaoImpl implements FeatureDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Feature getFeature(Long id) {
        return entityManager.find(Feature.class, id);
    }

    @Override
    @Transactional
    public void createFeature(Feature feature) {
        entityManager.persist(feature);
    }

    @Override
    @Transactional
    public void updateFeature(Feature feature) {
        entityManager.merge(feature);
    }

    @Override
    public void deleteFeature(Feature feature) {
        entityManager.remove(feature);
    }
}
