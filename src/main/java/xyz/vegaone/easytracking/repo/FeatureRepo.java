package xyz.vegaone.easytracking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.Feature;

@Repository
public interface FeatureRepo extends JpaRepository<Feature, Long> {
}
