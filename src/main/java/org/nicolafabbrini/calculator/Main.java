package org.nicolafabbrini.calculator;

import java.text.MessageFormat;
import java.util.Scanner;

public class Main {

    private static final String QUIT_COMMAND = "\\q";

    public static void main(final String[] args) {
        intro();

        final Calculator calculator = new Calculator();
        final Scanner scanner = new Scanner(System.in);

        // Infinite loop until user types \q
        String expression;
        do {
            System.out.print("Type your expression: ");
            expression = scanner.nextLine();

            // Skip to verify the while statement and leave the loop
            if(QUIT_COMMAND.equals(expression)) {
                continue;
            }

            // Performs the operation
            try {
                final double result = calculator.getResult(expression);
                System.out.println(MessageFormat.format("Result of {0} is {1}", expression, result));
            } catch (final Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!QUIT_COMMAND.equals(expression));
    }

    /**
     * Shows instructions on how to use the calculator.
     */
    private static void intro() {
        System.out.println("Program Author: Nicola Fabbrini");
        System.out.println("ASCII Art Author: David Berner & Nicola Fabbrini");
        System.out.println();
        System.out.println("                   /\"\\             ");
        System.out.println("  //  //       /\"\\|\\./|/\"\\      ");
        System.out.println("  ||  ||      |\\./|   |\\./|        ");
        System.out.println("  ||  ||      |   |   |   |          ");
        System.out.println("              |   |>~<|   |/\"\\     ");
        System.out.println("              |>~<|   |>~<|\\./|     ");
        System.out.println("              |   |   |   |   |      ");
        System.out.println("          /~T\\|   |   =[@]=   |     ");
        System.out.println("          |_/ |   |   |   |   |      ");
        System.out.println("          |   | ~   ~   ~ |   |      ||  ||");
        System.out.println("          |~< |             ~ |      ||  ||");
        System.out.println("          |   '               |      //  //");
        System.out.println("          \\                   |     ");
        System.out.println("           \\                 /      ");
        System.out.println("            \\               /       ");
        System.out.println("             \\.            /        ");
        System.out.println("               |          |          ");
        System.out.println("               |          |          ");
        System.out.println();
        System.out.println("Welcome to YourWave! Our newest calculator with anti-floating point error (cheat) system.");
        System.out.println("This calculator is currently able to perform the following operations: ");
        System.out.println("- Addition -> Syntax is {x} + {y}");
        System.out.println("- Subtraction -> Syntax is {x} - {y}");
        System.out.println("- Multiplication -> Syntax is {x} * {y}");
        System.out.println("- Division -> Syntax is {x} / {y}");
        System.out.println(MessageFormat.format("- Quit -> Syntax is {0}", QUIT_COMMAND));
    }
}
