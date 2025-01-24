package com.kyoto;

import com.kyoto.functions.Ln;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LnTest {

    private Ln ln;

    @BeforeEach
    void init() {
        ln = new Ln(20);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.5, 0.707, 1.0, 1.2, 2.0, 2.2})
    void testLn(double d) {
        assertEquals(ln.apply(d), Math.log(d), 0.1);
    }
}
