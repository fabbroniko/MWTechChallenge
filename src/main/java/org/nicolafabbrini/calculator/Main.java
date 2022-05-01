package org.nicolafabbrini.calculator;

import java.text.MessageFormat;

public class Main {

    public static void main(final String[] args) {
        final Calculator calculator = new Calculator();

        // Sets the expression from the first *Program Argument* if available.
        String expression = null;
        if(args.length > 0) {
            expression = args[0];
        }

        // Tries to perform the calculation. Exceptions include infinity (0/0), undefined (5/0) and input validation errors.
        try {
            final double result = calculator.getResult(expression);
            System.out.println(MessageFormat.format("Result of {0} is {1}", expression, result));
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
