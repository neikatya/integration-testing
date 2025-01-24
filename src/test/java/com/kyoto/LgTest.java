package com.kyoto;

import com.kyoto.functions.Cos;
import com.kyoto.functions.Ln;
import com.kyoto.functions.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

public class LgTest {

    private Log log;

    @BeforeEach
    void init() {
        log = new Log(20, 10);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.4, 0.7, 1.0, 1.3, 1.6, 1.8, 10})
    void testLg(double d) {
        assertEquals(log.apply(d), Math.log10(d), 0.1);
    }

    @Test
    public void mockTest() {
        Ln mockLn = Mockito.mock(Ln.class);
        when(mockLn.apply(anyDouble())).thenAnswer((Answer<Double>) invocation -> {
            Double arg = invocation.getArgument(0);
            return Math.log(arg);
        });
        log.setLn(mockLn);
        Double x = 10.0;
        Double result = log.apply(x);

        assertEquals(1, result, 0.1, "Calculated cosine does not match the expected value.");
    }
}
