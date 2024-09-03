package com.healthcare_app.api_gateway.repository;

import com.healthcare_app.api_gateway.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for User entities.
 * Extends JpaRepository to provide CRUD operations and additional custom methods.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a User entity by its login.
     *
     * @param login The login identifier of the user.
     * @return An Optional containing the User entity if found, or an empty Optional otherwise.
     */
    Optional<User> findByLogin(String login);
}
