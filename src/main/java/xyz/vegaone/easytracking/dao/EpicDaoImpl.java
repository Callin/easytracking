package xyz.vegaone.easytracking.dao;

import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.Epic;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class EpicDaoImpl implements EpicDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Epic getEpic(Long id) {
        return entityManager.find(Epic.class, id);
    }

    @Override
    public void createEpic(Epic epic) {
        entityManager.persist(epic);
    }

    @Override
    public void updateEpic(Epic epic) {
        entityManager.merge(epic);
    }

    @Override
    public void deleteEpic(Epic epic) {
        entityManager.remove(epic);
    }
}
