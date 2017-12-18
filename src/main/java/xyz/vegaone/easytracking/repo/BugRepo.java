package xyz.vegaone.easytracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.BugEnitty;

@Repository
public interface BugRepo extends JpaRepository<BugEnitty, Long> {
}
