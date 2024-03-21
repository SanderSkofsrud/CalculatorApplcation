package org.example.springbootbackend.controller;

import org.example.springbootbackend.dto.EquationDTO;
import org.example.springbootbackend.dto.UserDTO;
import org.example.springbootbackend.service.CalculationService;
import org.example.springbootbackend.service.LogService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * The type Log controller.
 */
@CrossOrigin(origins = "*")
@RequestMapping("/calculator/log")
@RestController
@RequiredArgsConstructor
public class LogController {

    private final Logger logger = LoggerFactory.getLogger(CalculationController.class);
    private final CalculationService calculationService;
    private final LogService logService;


    /**
     * Load data response entity.
     *
     * @param userDTO the user dto
     * @return the response entity
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/load")
    @ResponseBody
    public ResponseEntity<List<EquationDTO>> loadData(@RequestBody UserDTO userDTO) {
        try {
            List<EquationDTO> equations = calculationService.getAllEquations(userDTO);
            logger.info(String.format("%s has accessed their log", userDTO.getUsername()));
            return ResponseEntity.ok(equations);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return ResponseEntity.internalServerError().body(null);
        }

    }


    /**
     * Delete response entity.
     *
     * @return the response entity
     */
    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<Object> delete() {
        try {
            logService.deleteLog();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return ResponseEntity.internalServerError().body(null);
        }

    }


}
