package xyz.vegaone.easytracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
}
