package org.nicolafabbrini.calculator.module;

/**
 * This class represents any operation that can be performed through this new calculator.
 * It defines methods that allow different strategies to be used to validate, calculate and round a mathematical operation.
 */
public abstract class AbstractOperation {

    private static final int ROUNDING_BASE = 10;
    private static final int ROUNDING_TO_DECIMAL_NUMBER = 3;

    protected String expression;

    /**
     * Constructs operation instance with the given expression
     * @param expression The expression defining a mathematical operation, like addition, subtraction, multiplication and division.
     */
    protected AbstractOperation(final String expression) {
        this.expression = expression;
    }

    /**
     * Performs the operation defined in the expression used to construct this object
     * @return Returns the result of the mathematical operation.
     */
    public double getResult() {
        if(!isValid()) {
            throw new IllegalArgumentException("The expression is not valid");
        }

        // Returns the result after rounding it
        return round(getResultInternal());
    }

    /**
     * Performs the actual operation.
     * The strategy is defined in children classes.
     * @return Returns the result of the mathematical operation.
     */
    protected abstract double getResultInternal();

    /**
     * Checks if this class can perform the computation
     * @return Returns true if the expression is valid for the instance of this class, false otherwise.
     */
    protected abstract boolean isValid();

    /**
     * The default strategy to overcome (hide in this case) floating point precision errors is going to be rounding the result to the third decimal number.
     */
    protected double round(final double result) {
        double scale = Math.pow(ROUNDING_BASE, ROUNDING_TO_DECIMAL_NUMBER);
        return Math.round(result * scale) / scale;
    }
}
