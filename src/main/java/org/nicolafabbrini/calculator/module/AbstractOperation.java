package org.nicolafabbrini.calculator.module;

import org.nicolafabbrini.calculator.exception.UnexpectedException;

/**
 * This class represents any operation that can be performed through this new calculator.
 * It defines methods that allow different strategies to be used to validate, calculate and round a mathematical operation.
 */
public abstract class AbstractOperation {

    private static final int ROUNDING_BASE = 10;
    private static final int ROUNDING_TO_DECIMAL_NUMBER = 3;

    /**
     * Performs the operation defined in the expression passed to this method.
     *
     * @param expression The expression of the mathematical operation the user wants to compute.
     * @return Returns the result of the mathematical operation.
     */
    public double getResult(final String expression) {
        if(!isValid(expression)) {
            throw new UnexpectedException();
        }

        // Returns the result after rounding it
        return round(getResultInternal(expression));
    }

    /**
     * Performs the actual operation.
     * The strategy is defined in children classes.
     *
     * @param expression The expression of the mathematical operation the user wants to compute.
     * @return Returns the result of the mathematical operation.
     */
    protected abstract double getResultInternal(final String expression);

    /**
     * Checks if this class can perform the computation
     *
     * @param expression The expression to validate.
     * @return Returns true if the expression is valid for the instance of this class, false otherwise.
     */
    public abstract boolean isValid(final String expression);

    /**
     * The default strategy to overcome (hide in this case) floating point precision errors is going to be rounding the result to the third decimal number.
     */
    protected double round(final double result) {
        double scale = Math.pow(ROUNDING_BASE, ROUNDING_TO_DECIMAL_NUMBER);
        return Math.round(result * scale) / scale;
    }
}
