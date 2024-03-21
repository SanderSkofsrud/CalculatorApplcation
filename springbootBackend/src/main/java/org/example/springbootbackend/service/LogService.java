package org.example.springbootbackend.service;

import org.example.springbootbackend.mapper.CalculationMapper;
import org.example.springbootbackend.repo.EquationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * The type Log service.
 */
@Service
@RequiredArgsConstructor
public class LogService {

    private final EquationRepository equationRepository;
    private final CalculationMapper calculationMapper;
    private final CalculationService calculationService;
    private final Logger logger = LoggerFactory.getLogger(CalculationService.class);

    /**
     * Delete log.
     */
    public void deleteLog() {

        equationRepository.deleteAll();

    }

}