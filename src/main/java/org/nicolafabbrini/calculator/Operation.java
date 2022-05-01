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

        if(!Pattern.matches("([0-9]+([.]?[0-9]+)?)\\s+[\\+]{1}\\s+([0-9]+([.]?[0-9]+)?)", expression)) {
            throw new IllegalArgumentException("The expression is not valid");
        }

        return -1;
    }
}
