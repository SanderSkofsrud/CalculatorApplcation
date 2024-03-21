package org.example.springbootbackend.controller;

/**
 * The type Calculation save request.
 */
public class CalculationSaveRequest {
    private Long userId;
    private String expression;
    private Double result;

    /**
     * Gets user id.
     *
     * @return the user id
     */
// Getters and setters
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets expression.
     *
     * @return the expression
     */
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
    public double getResult() {

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
