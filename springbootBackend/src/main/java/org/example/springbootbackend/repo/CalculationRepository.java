package org.example.springbootbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.example.springbootbackend.model.Calculation;

/**
 * The interface Calculation repository.
 */
public interface CalculationRepository extends JpaRepository<Calculation, Long> {

    /**
     * Find by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<Calculation> findByUserId(Long userId);


}