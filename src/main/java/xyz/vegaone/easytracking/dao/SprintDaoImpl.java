package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.Sprint;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class SprintDaoImpl implements SprintDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Sprint getSprint(Long id) {
        return entityManager.find(Sprint.class, id);
    }

    @Override
    public void createSprint(Sprint sprint) {

        entityManager.merge(sprint);
    }

    @Override
    public void updateSprint(Sprint sprint) {
        entityManager.merge(sprint);
    }

    @Override
    public void deleteSprint(Sprint sprint) {
        entityManager.remove(sprint);
    }
}
