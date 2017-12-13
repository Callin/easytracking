package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.Bug;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class BugDaoImpl implements BugDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Bug getBug(Long id) {
        return entityManager.find(Bug.class, id);
    }

    @Override
    @Transactional
    public void createBug(Bug bug) {
        entityManager.persist(bug);
    }

    @Override
    @Transactional
    public void updateBug(Bug bug) {
        entityManager.merge(bug);
    }

    @Override
    public void deleteBug(Bug bug) {
        entityManager.remove(bug);
    }
}
