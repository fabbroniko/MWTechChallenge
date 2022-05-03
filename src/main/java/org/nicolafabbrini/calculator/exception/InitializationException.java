package org.nicolafabbrini.calculator.exception;

public class InitializationException extends RuntimeException {

    public InitializationException() {
        super("The calculator could not be initialized.");
    }
}
