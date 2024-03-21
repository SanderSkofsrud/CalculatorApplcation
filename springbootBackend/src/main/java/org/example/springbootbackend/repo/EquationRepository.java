package org.example.springbootbackend.repo;


import org.example.springbootbackend.model.Equation;
import org.example.springbootbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface Equation repository.
 */
@Repository
public interface EquationRepository extends JpaRepository<Equation, Integer> {
    /**
     * Find all by user optional.
     *
     * @param user the user
     * @return the optional
     */
    Optional<List<Equation>> findAllByUser(User user);

    /**
     * Find all by user username optional.
     *
     * @param username the username
     * @return the optional
     */
    Optional<List<Equation>> findAllByUser_Username(String username);
}