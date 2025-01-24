package com.kyoto;

import com.kyoto.functions.Cos;
import com.kyoto.functions.Factorial;
import com.kyoto.functions.Ln;
import com.kyoto.functions.Log;
import com.kyoto.functions.Sec;
import com.kyoto.functions.Sin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

class EquationsSystemTest {

    private EquationsSystem system;

    @BeforeEach
    void init() {
        system = new EquationsSystem(20);
    }

    @Test
    void testFactorial() {
        assertEquals(0.414, system.apply(-2.4), 0.1);
        assertEquals(10.375, system.apply(-1.2), 0.1);
        assertEquals(2.0, system.apply(0.0), 0.1);
        assertEquals(NaN, system.apply(1.0));
        assertEquals(1.179, system.apply(3.3), 0.1);
    }

    @Test
    public void mockTest() {
        Cos mockCos = Mockito.mock(Cos.class);
        when(mockCos.apply(anyDouble())).thenAnswer((Answer<Double>) invocation -> {
            Double arg = invocation.getArgument(0);
            return Math.cos(arg);
        });

        Sec mockSec = Mockito.mock(Sec.class);
        when(mockSec.apply(anyDouble())).thenAnswer((Answer<Double>) invocation -> {
            Double arg = invocation.getArgument(0);
            return 1 / Math.cos(arg);
        });

        Ln mockLn = Mockito.mock(Ln.class);
        when(mockLn.apply(anyDouble())).thenAnswer((Answer<Double>) invocation -> {
            Double arg = invocation.getArgument(0);
            return Math.log(arg);
        });

        Log mockLog10 = Mockito.mock(Log.class);
        when(mockLog10.apply(anyDouble())).thenAnswer((Answer<Double>) invocation -> {
            Double arg = invocation.getArgument(0);
            return Math.log10(arg);
        });

        Log mockLog3 = Mockito.mock(Log.class);
        when(mockLog3.apply(anyDouble())).thenAnswer((Answer<Double>) invocation -> {
            Double arg = invocation.getArgument(0);
            return Math.log(arg) / Math.log(3);
        });

        Log mockLog5 = Mockito.mock(Log.class);
        when(mockLog5.apply(anyDouble())).thenAnswer((Answer<Double>) invocation -> {
            Double arg = invocation.getArgument(0);
            return Math.log(arg) / Math.log(5);
        });

        system.setLN(mockLn);
        system.setLOG10(mockLog10);
        system.setLOG5(mockLog5);
        system.setLOG3(mockLog3);
        system.setSEC(mockSec);
        system.setCOS(mockCos);

        Double x = 3.3;
        Double result = system.apply(x);

        assertEquals(1.179, result, 0.1, "Calculated cosine does not match the expected value.");
    }
}
