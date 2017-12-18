package xyz.vegaone.easytracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.SprintEntity;

@Repository
public interface SprintRepo extends JpaRepository<SprintEntity, Long> {
}
