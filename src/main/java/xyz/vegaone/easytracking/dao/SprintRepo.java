package xyz.vegaone.easytracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.Sprint;

@Repository
public interface SprintRepo extends JpaRepository<Sprint, Long> {
}
