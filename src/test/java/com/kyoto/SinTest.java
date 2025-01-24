package com.kyoto;

import com.kyoto.functions.Cos;
import com.kyoto.functions.Factorial;
import com.kyoto.functions.Sin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class SinTest {
    private Sin sin;

    @BeforeEach
    void init() {
        sin = new Sin(20);
    }

    @ParameterizedTest
    @ValueSource(doubles = { (-1) * Math.PI / 4, 0, Math.PI / 4, Math.PI / 2, Math.PI})
    void testSin(double d) {
        assertEquals(sin.apply(d), Math.sin(d), 0.1);
    }

    @Test
    public void mockTest() {
        Cos mockCos = Mockito.mock(Cos.class);
        when(mockCos.apply(anyDouble())).thenAnswer((Answer<Double>) invocation -> {
            Double arg = invocation.getArgument(0);
            return Math.cos(arg);
        });
        sin.setCOS(mockCos);
        Double x = Math.PI / 3;
        Double result = sin.apply(x);

        assertEquals(Math.sin(x), result, 0.01, "Calculated cosine does not match the expected value.");
    }
}
