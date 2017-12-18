package xyz.vegaone.easytracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.TaskEnitty;

@Repository
public interface TaskRepo extends JpaRepository<TaskEnitty, Long> {

}
