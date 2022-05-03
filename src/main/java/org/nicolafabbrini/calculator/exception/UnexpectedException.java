package org.nicolafabbrini.calculator.exception;

/**
 * Indicates an unforeseen-unforeseen (unforeseen^2) exception, and it's likely to require the dev's attention.
 */
public class UnexpectedException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Something went wrong. Please contact the author, we are currently unable to notify our devs automatically.";

    public UnexpectedException() {
        super(ERROR_MESSAGE);
    }
}
