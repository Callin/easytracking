package xyz.vegaone.easytracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.Epic;

@Repository
public interface EpicRepo extends JpaRepository<Epic, Long> {
}
