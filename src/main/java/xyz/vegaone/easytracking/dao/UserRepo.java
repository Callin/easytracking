package xyz.vegaone.easytracking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.vegaone.easytracking.domain.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}