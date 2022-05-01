package org.nicolafabbrini.calculator;

import java.util.Optional;

public class Operation {

    private final String expression;

    public Operation(final String expression) {
        this.expression = expression;
    }

    public double getResult() {
        Optional.ofNullable(expression).orElseThrow(() -> new IllegalArgumentException("The expression must be set"));

        return -1;
    }
}
