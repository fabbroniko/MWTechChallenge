package org.nicolafabbrini.calculator.module;

import java.util.regex.Pattern;

public class ArithmeticOperation extends AbstractOperation {

    @Override
    protected double getResultInternal(final String expression) {
        final ExpressionParameters expressionParameters = new ExpressionParameters(expression);

        return switch (expressionParameters.operator) {
            case "+" -> expressionParameters.x + expressionParameters.y;
            case "-" -> expressionParameters.x - expressionParameters.y;
            case "*" -> expressionParameters.x * expressionParameters.y;
            default -> throw new IllegalArgumentException();
        };
    }

    @Override
    protected boolean isValid(final String expression) {
        return Pattern.matches("(\\d+([.]?\\d+)?)\\s[+\\-*]\\s(\\d+([.]?\\d+)?)", expression);
    }

    /**
     * Defines the parameters of the expression passed.
     */
    private static class ExpressionParameters {

        private static final int FIRST_OPERAND_INDEX = 0;

        private static final int OPERATOR_INDEX = 1;
        private static final int SECOND_OPERAND_INDEX = 2;

        private final double x;

        private final double y;

        private final String operator;

        private ExpressionParameters(final String expression) {
            final String[] split = expression.split("\\s");
            this.x = Double.parseDouble(split[FIRST_OPERAND_INDEX]);
            this.y = Double.parseDouble(split[SECOND_OPERAND_INDEX]);
            this.operator = split[OPERATOR_INDEX];
        }
    }
}
