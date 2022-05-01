package org.nicolafabbrini.calculator;

import org.nicolafabbrini.calculator.module.ArithmeticOperation;

import java.util.Optional;

/**
 * Represents the calculator used by the user to perform any kind of mathematical operation.
 */
public class Calculator {

    /**
     * Returns the result of the operation described by the expression passed to this method.
     * @return The result of the expression.
     */
    public double getResult(final String expression) {
        Optional.ofNullable(expression).orElseThrow(() -> new IllegalArgumentException("The expression must be set"));

        return new ArithmeticOperation().getResult(expression);
    }
}
