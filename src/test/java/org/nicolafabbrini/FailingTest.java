package org.nicolafabbrini;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class FailingTest {

    @Test
    public void testWorkflow(){
        fail();
    }
}
