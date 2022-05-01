package org.nicolafabbrini.calculator;

import java.util.Optional;

public class Operation {

    private final String expression;

    public Operation(final String expression) {
        this.expression = expression;
    }

    public double getResult() {
        Optional.ofNullable(expression).orElseThrow(IllegalArgumentException::new);

        return -1;
    }
}
