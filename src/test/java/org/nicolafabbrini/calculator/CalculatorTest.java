package org.nicolafabbrini.calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testCalculatorNullInput() {
        final Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.getResult(null));
    }

    @Test
    public void testCalculatorNullInputWithMessage() {
        final Calculator calculator = new Calculator();
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> calculator.getResult(null));

        assertEquals("The expression must be set", thrown.getMessage());
    }

    @Test
    public void testCalculatorWithWrongExpressionFormat() {
        final Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.getResult("Hello"));
    }

    @Test
    public void testCalculatorWrongFormatWithMessage() {
        final Calculator calculator = new Calculator();
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> calculator.getResult("Hello"));

        assertEquals("The expression is not valid", thrown.getMessage());
    }

    @Test
    public void testValidAdditionFormat() {
        final Calculator calculator = new Calculator();
        assertDoesNotThrow(() -> calculator.getResult("1.3 + 1.6"));
    }

    @Test
    public void testAddition() {
        final Calculator calculator = new Calculator();
        assertEquals(2.9, calculator.getResult("1.3 + 1.6"));
    }

    @Test
    public void testValidSubtractionFormat() {
        final Calculator calculator = new Calculator();
        assertDoesNotThrow(() -> calculator.getResult("10 - 4"));
    }

    @Test
    public void testSubtraction() {
        final Calculator calculator = new Calculator();
        assertEquals(6, calculator.getResult("10 - 4"));
    }

    @Test
    public void testValidMultiplicationFormat() {
        final Calculator calculator = new Calculator();
        assertDoesNotThrow(() -> calculator.getResult("3 * 5"));
    }

    @Test
    public void testMultiplication() {
        final Calculator calculator = new Calculator();
        assertEquals(15, calculator.getResult("3 * 5"));
    }

    @Test
    public void testValidDivisionFormat() {
        final Calculator calculator = new Calculator();
        assertDoesNotThrow(() -> calculator.getResult("19 / 2"));
    }

    @Test
    public void testDivisionZeroDividend() {
        final Calculator calculator = new Calculator();
        assertEquals(0, calculator.getResult("0 / 4"));
    }

    @Test
    public void testDivisionZeroDivisor() {
        final Calculator calculator = new Calculator();
        final Exception thrown = assertThrows(MathException.class, () -> calculator.getResult("5 / 0"));

        assertEquals("undefined", thrown.getMessage());
    }

    @Test
    public void testDividingZeroByZero() {
        final Calculator calculator = new Calculator();
        final Exception thrown = assertThrows(MathException.class, () -> calculator.getResult("0 / 0"));

        assertEquals("infinity", thrown.getMessage());
    }

    @Test
    public void testDivision() {
        final Calculator calculator = new Calculator();
        assertEquals(5, calculator.getResult("15 / 3"));
    }
}
