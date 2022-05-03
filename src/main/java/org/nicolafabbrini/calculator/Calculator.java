package org.nicolafabbrini.calculator;

import org.nicolafabbrini.calculator.exception.IllegalExpressionException;
import org.nicolafabbrini.calculator.module.AbstractOperation;

import java.util.List;
import java.util.Optional;

/**
 * Represents the calculator used by the user to perform any kind of mathematical operation.
 */
public class Calculator {

    private static final String EXCEPTION_MESSAGE = "The expression is not valid";

    private final List<? extends AbstractOperation> operationsAvailable;

    public Calculator() {
        operationsAvailable = CalculatorModuleLoader.getModules();
    }

    /**
     * Returns the result of the operation described by the expression passed to this method.
     * @return The result of the expression.
     */
    public double getResult(final String expression) {
        Optional.ofNullable(expression).orElseThrow(() -> new IllegalArgumentException("The expression must be set"));

        /*
         * Attempts to run the calculation with each module loaded into the application.
         * It returns the first available result or propagates the exception if required.
         */
        for(AbstractOperation currentAvailableOperation : operationsAvailable) {
            try {
                return currentAvailableOperation.getResult(expression);
            } catch (final Exception e) {
                if(!EXCEPTION_MESSAGE.equals(e.getMessage())) {
                    throw e;
                }
            }
        }

        throw new IllegalExpressionException();
    }
}
