package org.nicolafabbrini.calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OperationTest {

    @Test
    public void testOperationNullInput() {
        final Operation operation = new Operation(null);
        assertThrows(IllegalArgumentException.class, operation::getResult);
    }

    @Test
    public void testOperationNullInputWithMessage() {
        final Operation operation = new Operation(null);
        Exception thrown = assertThrows(IllegalArgumentException.class, operation::getResult);

        assertEquals("The expression must be set", thrown.getMessage());
    }
}
