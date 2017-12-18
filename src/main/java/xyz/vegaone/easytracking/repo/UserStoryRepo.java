package xyz.vegaone.easytracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.UserStoryEnitty;

@Repository
public interface UserStoryRepo extends JpaRepository<UserStoryEnitty, Long> {
}
