package org.example.springbootbackend.dto;

/**
 * The type Calculation dto.
 */
public class CalculationDTO {
    private String expression;
    private Double result;

    /**
     * Instantiates a new Calculation dto.
     *
     * @param expression the expression
     * @param result     the result
     */
// Constructor, getters, and setters
    public CalculationDTO(String expression, String result) {
        this.expression = expression;
        this.result = Double.valueOf(result);
    }

    /**
     * Gets expression.
     *
     * @return the expression
     */
// Getters and setters
    public String getExpression() {
        return expression;
    }

    /**
     * Sets expression.
     *
     * @param expression the expression
     */
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public Double getResult() {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(Double result) {
        this.result = result;
    }
}
