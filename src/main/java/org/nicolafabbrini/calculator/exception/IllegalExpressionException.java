package org.nicolafabbrini.calculator.exception;

/**
 * Exception that indicates an expression that un unprocessable by all the modules loaded into the calculator.
 */
public class IllegalExpressionException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "The expression is not valid";

    public IllegalExpressionException() {
        super(ERROR_MESSAGE);
    }
}
