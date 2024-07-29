package com.healthcare_app.api_gateway.repository;

import com.healthcare_app.api_gateway.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByLogin(String login);
}
