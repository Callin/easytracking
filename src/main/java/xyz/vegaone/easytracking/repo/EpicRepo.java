package xyz.vegaone.easytracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.EpicEntity;

@Repository
public interface EpicRepo extends JpaRepository<EpicEntity, Long> {
}
