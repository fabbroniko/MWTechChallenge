package org.nicolafabbrini.calculator;

import org.nicolafabbrini.calculator.exception.IllegalExpressionException;
import org.nicolafabbrini.calculator.module.AbstractOperation;

import java.util.List;
import java.util.Optional;

/**
 * Represents the calculator used by the user to perform any kind of mathematical operation.
 */
public class Calculator {

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

        // Use the first module that is capable of processing the expression.
        return operationsAvailable.stream()
                .filter((o) -> o.isValid(expression))
                .findFirst().orElseThrow(IllegalExpressionException::new)
                .getResult(expression);
    }
}
