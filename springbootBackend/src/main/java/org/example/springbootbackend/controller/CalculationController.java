package org.example.springbootbackend.controller;

import org.example.springbootbackend.dto.CalculationDTO;
import org.example.springbootbackend.model.Calculation;
import org.example.springbootbackend.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import static net.logstash.logback.argument.StructuredArguments.keyValue;


/**
 * The type Calculation controller.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/calculator")
public class CalculationController {

    private final CalculationService calculationService;

    /**
     * The Logger.
     */
    Logger logger = LoggerFactory.getLogger(CalculationController.class);

    private ControllerModel calculatorModel = new ControllerModel();


    /**
     * Instantiates a new Calculation controller.
     *
     * @param calculationService the calculation service
     */
    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }


    /**
     * Evaluate response entity.
     *
     * @param expression the expression
     * @return the response entity
     */
    @GetMapping("/evaluate")
    public ResponseEntity<Double> evaluate(@RequestParam String expression) {
        try {
            double result = calculatorModel.evaluate(expression);
            logger.info("Calculation performed", keyValue("calculation", expression), keyValue("result", result));
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("Error evaluating expression", keyValue("expression", expression), keyValue("error", e.getMessage()));
            return ResponseEntity.badRequest().body(null);
        }
    }


    /**
     * Save calculation response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/save")
    public ResponseEntity<?> saveCalculation(@RequestBody CalculationSaveRequest request) {
        try {
            logger.info("trying to save calculation", keyValue("user", request.getUserId()), keyValue("calculation", request.getExpression()), keyValue("result", request.getResult()));
            calculationService.saveCalculation(request.getUserId(), request.getExpression(), String.valueOf(request.getResult()));
            logger.info("Calculation saved successfully.", keyValue("user", request.getUserId()), keyValue("calculation", request.getExpression()), keyValue("result", request.getResult()));
            return ResponseEntity.ok().body("Calculation saved successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to save calculation: " + e.getMessage());
        }
    }


    /**
     * Gets calculation history by user id.
     *
     * @param userId the user id
     * @return the calculation history by user id
     */
    @GetMapping("/calculations/history/{userId}")
    public ResponseEntity<List<CalculationDTO>> getCalculationHistoryByUserId(@PathVariable Long userId) {
        try {
            List<Calculation> calculations = calculationService.getCalculationHistoryForUser(userId);
            if (calculations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            // Map the Calculation entities to Data Transfer Objects (DTOs) to send to the client
            List<CalculationDTO> calculationDTOS = calculations.stream()
                    .map(calculation -> new CalculationDTO(calculation.getExpression(), calculation.getResult()))
                    .collect(Collectors.toList());

            return new ResponseEntity<>(calculationDTOS, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error getting calculation history for user: {}", userId, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }











}
