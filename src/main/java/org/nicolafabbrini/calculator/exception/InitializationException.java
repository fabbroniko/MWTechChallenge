package org.nicolafabbrini.calculator.exception;

/**
 * The application couldn't be initialised.
 */
public class InitializationException extends RuntimeException {

    private static final String ERROR_MESSAGE = "The calculator could not be initialized.";

    public InitializationException() {
        super(ERROR_MESSAGE);
    }
}
