package org.example.springbootbackend.dto;


import lombok.Builder;

/**
 * The type Equation dto.
 */
@Builder
public record EquationDTO(String expression, double result) {
}