package org.nicolafabbrini.calculator.exception;

public class IllegalExpressionException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "The expression is not valid";

    public IllegalExpressionException() {
        super(ERROR_MESSAGE);
    }
}
