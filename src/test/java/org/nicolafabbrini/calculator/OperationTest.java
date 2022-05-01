package org.nicolafabbrini.calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class OperationTest {

    @Test
    public void testOperationNullInput() {
        final Operation operation = new Operation(null);
        assertThrows(IllegalArgumentException.class, operation.getResult());
    }
}
