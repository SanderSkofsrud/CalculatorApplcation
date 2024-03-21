package org.example.springbootbackend.controller;


import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * The type Controller model.
 */
public class ControllerModel {

    private final ExpressionParser parser = new SpelExpressionParser();

    /**
     * Evaluate double.
     *
     * @param expression the expression
     * @return the double
     * @throws Exception the exception
     */
    public double evaluate(String expression) throws Exception {
        Expression exp = parser.parseExpression(expression);
        return exp.getValue(Double.class);
    }
}
