package org.nicolafabbrini.calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testCalculatorNullInput() {
        final Calculator calculator = new Calculator(null);
        assertThrows(IllegalArgumentException.class, calculator::getResult);
    }

    @Test
    public void testCalculatorNullInputWithMessage() {
        final Calculator calculator = new Calculator(null);
        Exception thrown = assertThrows(IllegalArgumentException.class, calculator::getResult);

        assertEquals("The expression must be set", thrown.getMessage());
    }

    @Test
    public void testCalculatorWithWrongExpressionFormat() {
        final Calculator calculator = new Calculator("Hello");
        assertThrows(IllegalArgumentException.class, calculator::getResult);
    }

    @Test
    public void testCalculatorWrongFormatWithMessage() {
        final Calculator calculator = new Calculator("Hello");
        Exception thrown = assertThrows(IllegalArgumentException.class, calculator::getResult);

        assertEquals("The expression is not valid", thrown.getMessage());
    }

    @Test
    public void testValidAdditionFormat() {
        final Calculator calculator = new Calculator("1.3 + 1.6");
        assertDoesNotThrow(calculator::getResult);
    }

    @Test
    public void testAddition() {
        final Calculator calculator = new Calculator("1.3 + 1.6");
        assertEquals(2.9, calculator.getResult());
    }
}
