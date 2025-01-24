package com.kyoto;

import com.kyoto.functions.Cos;
import com.kyoto.functions.Sec;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

class SecTest {
    
    private Sec sec;

    @BeforeEach
    void init() {
        sec = new Sec(20);
    }

    @ParameterizedTest
    @ValueSource(doubles = { -2, -1.5, -0.5, 0, 0.5, 1.0, 2.0})
    void testSec(double d) {
        assertEquals(sec.apply(d), Math.pow(Math.cos(d), -1), 0.1);
    }

    @Test
    public void mockTest() {
        Cos mockCos = Mockito.mock(Cos.class);
        when(mockCos.apply(anyDouble())).thenAnswer((Answer<Double>) invocation -> {
            Double arg = invocation.getArgument(0);
            return Math.cos(arg);
        });
        sec.setCOS(mockCos);
        Double x = 1.0;
        Double result = sec.apply(x);

        assertEquals(Math.pow(Math.cos(x), -1), result, 0.1, "Calculated cosine does not match the expected value.");
    }
}
