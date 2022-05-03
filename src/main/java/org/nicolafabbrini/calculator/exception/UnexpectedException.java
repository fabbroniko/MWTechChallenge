package org.nicolafabbrini.calculator.exception;

public class UnexpectedException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Something went wrong. Please contact the author, we are currently unable to notify our devs automatically.";

    public UnexpectedException() {
        super(ERROR_MESSAGE);
    }
}
