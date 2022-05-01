package org.nicolafabbrini.calculator;

import java.text.MessageFormat;
import java.util.Scanner;

public class Main {

    private static final String QUIT_COMMAND = "\\q";

    public static void main(final String[] args) {
        intro();

        final Scanner scanner = new Scanner(System.in);
        String expression = null;

        do {
            System.out.print("Type your expression: ");
            expression = scanner.nextLine();
            if(!QUIT_COMMAND.equals(expression)) {
                try {
                    final double result = new Operation(expression).getResult();
                    System.out.println(MessageFormat.format("Result of {0} is {1}", expression, result));
                } catch (final Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        } while (!QUIT_COMMAND.equals(expression));
    }

    private static void intro() {
        System.out.println("Program Author: Nicola Fabbrini");
        System.out.println("ASCII Art Author: David Berner + Nicola Fabbrini");
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
        System.out.println("This calculator is currently able to support the following operations: ");
        System.out.println("- Addition -> Syntax is {x} + {y}");
        System.out.println(MessageFormat.format("- Quit -> Syntax is {0}", QUIT_COMMAND));
    }
}
