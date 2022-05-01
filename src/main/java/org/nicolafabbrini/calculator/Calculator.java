package org.nicolafabbrini.calculator;

import org.nicolafabbrini.calculator.module.AbstractOperation;
import org.nicolafabbrini.calculator.module.ArithmeticOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents the calculator used by the user to perform any kind of mathematical operation.
 */
public class Calculator {

    private static final String EXCEPTION_MESSAGE = "The expression is not valid";

    private final List<AbstractOperation> operationsAvailable = new ArrayList<>();

    public Calculator() {
        operationsAvailable.add(new ArithmeticOperation());
    }

    /**
     * Returns the result of the operation described by the expression passed to this method.
     * @return The result of the expression.
     */
    public double getResult(final String expression) {
        Optional.ofNullable(expression).orElseThrow(() -> new IllegalArgumentException("The expression must be set"));

        /*
         * This is to easily add modules (like trigonometry or logarithms) to the calculator without changing anything
         * in the calculators code other than adding the module in the 'operationsAvailable' list.
         *
         * A better way to do this that would require no changes at all would be through the use of reflection. Simply
         * add the module in the repository, and it would be picked up automatically.
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

        throw new IllegalArgumentException("The expression is not valid");
    }
}
