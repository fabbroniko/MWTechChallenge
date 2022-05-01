package org.nicolafabbrini.calculator.module;

import java.util.regex.Pattern;

public class ArithmeticOperation extends AbstractOperation {

    @Override
    protected double getResultInternal(final String expression) {
        final Operands operands = new Operands(expression);

        return operands.x + operands.y;
    }

    @Override
    protected boolean isValid(final String expression) {
        return Pattern.matches("(\\d+([.]?\\d+)?)\\s[+]\\s(\\d+([.]?\\d+)?)", expression);
    }

    /**
     * Defines an operand class containing both operands from an arithmetic expression.
     */
    private static class Operands {

        private static final int FIRST_OPERAND_INDEX = 0;
        private static final int SECOND_OPERAND_INDEX = 2;

        private final double x;
        private final double y;

        private Operands(final String expression) {
            final String[] split = expression.split("\\s");
            this.x = Double.parseDouble(split[FIRST_OPERAND_INDEX]);
            this.y = Double.parseDouble(split[SECOND_OPERAND_INDEX]);
        }
    }
}
