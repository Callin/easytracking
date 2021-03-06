package xyz.vegaone.easytracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.UserStory;

@Repository
public interface UserStoryRepo extends JpaRepository<UserStory, Long> {
}
