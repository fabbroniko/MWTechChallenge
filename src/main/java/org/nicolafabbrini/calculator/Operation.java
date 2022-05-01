package org.nicolafabbrini.calculator;

import java.util.Optional;
import java.util.regex.Pattern;

public class Operation {

    private final String expression;

    public Operation(final String expression) {
        this.expression = expression;
    }

    public double getResult() {
        Optional.ofNullable(expression).orElseThrow(() -> new IllegalArgumentException("The expression must be set"));

        if(!Pattern.matches("([0-9]+([.]?[0-9]+)?)\\s{1}[\\+]{1}\\s{1}([0-9]+([.]?[0-9]+)?)", expression)) {
            throw new IllegalArgumentException("The expression is not valid");
        }

        String[] sOperands = expression.split("\\s{1}[\\+]{1}\\s{1}");
        double x = Double.parseDouble(sOperands[0]);
        double y = Double.parseDouble(sOperands[1]);

        // Truncate digits to avoid floating point errors in the result
        double scale = Math.pow(10, 3);

        return Math.round((x + y)*scale)/scale;
    }
}
