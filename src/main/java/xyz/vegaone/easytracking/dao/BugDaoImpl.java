package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.Bug;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BugDaoImpl implements BugDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Bug getBug(Long id) {
        return entityManager.find(Bug.class, id);
    }

    @Override
    public void createBug(Bug bug) {
        entityManager.persist(bug);
    }

    @Override
    public void updateBug(Bug bug) {
        entityManager.merge(bug);
    }

    @Override
    public void deleteBug(Bug bug) {
        entityManager.remove(bug);
    }
}
