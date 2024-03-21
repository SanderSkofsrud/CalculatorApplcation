package org.example.springbootbackend.repo;



import org.example.springbootbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    /**
     * Find user by username optional.
     *
     * @param username the username
     * @return the optional
     */
    Optional<User> findUserByUsername(String username);
}