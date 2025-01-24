package com.kyoto;

import com.kyoto.functions.Factorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTest {
    private Factorial factorial;

    @BeforeEach
    void init() {
        factorial = new Factorial();
    }

    @Test
    void testFactorial() {
        assertEquals(factorial.apply(1l), 1, 0.1);
        assertEquals(factorial.apply(5l), 120, 0.1);
        assertEquals(factorial.apply(-1l), 1, 0.1);
    }
}
