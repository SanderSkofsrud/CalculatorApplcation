package org.example.springbootbackend.mapper;



import org.example.springbootbackend.dto.EquationDTO;
import org.example.springbootbackend.dto.ExpressionDTO;
import org.example.springbootbackend.model.Equation;
import org.example.springbootbackend.model.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * The type Calculation mapper.
 */
@Component
public class CalculationMapper {

    /**
     * To equation equation.
     *
     * @param expression the expression
     * @param result     the result
     * @param user       the user
     * @return the equation
     */
    public Equation toEquation(ExpressionDTO expression, double result, User user) {
        String expressionString = String.join(" ", expression.elements());
        return Equation
                .builder()
                .expression(expressionString)
                .result(result)
                .user(user)
                .build();
    }

    /**
     * To expression expression dto.
     *
     * @param equation the equation
     * @return the expression dto
     */
    public ExpressionDTO toExpression(Equation equation) {
        String equationString = equation.getExpression() + " " + equation.getResult();
        return new ExpressionDTO(Arrays.stream(equationString.split(" ")).toList());
    }

    /**
     * To equation dto equation dto.
     *
     * @param equation the equation
     * @return the equation dto
     */
    public static EquationDTO toEquationDTO(Equation equation) {
        return EquationDTO
                .builder()
                .expression(equation.getExpression())
                .result(equation.getResult())
                .build();
    }

}