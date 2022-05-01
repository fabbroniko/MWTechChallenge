package org.nicolafabbrini.calculator;

import org.nicolafabbrini.calculator.module.ArithmeticOperation;

import java.util.Optional;

public class Calculator {

    private final String expression;

    public Calculator(final String expression) {
        this.expression = expression;
    }

    /**
     * Returns the result of the operation described by the expression passed when constructing this object.
     * @return The result represented as double
     */
    public double getResult() {
        Optional.ofNullable(expression).orElseThrow(() -> new IllegalArgumentException("The expression must be set"));

        return new ArithmeticOperation().getResult(expression);
    }
}
