package com.kyoto;

import com.kyoto.functions.Cos;
import com.kyoto.functions.Factorial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class CosTest {

    private Cos cos;

    @BeforeEach
    void init() {
        cos = new Cos(20);
    }

    @ParameterizedTest
    @ValueSource(doubles = {(-1) * Math.PI / 2, (-1) * Math.PI / 4, 0, Math.PI / 4, Math.PI / 2})
    void testCos(double d) {
        assertEquals(cos.apply(d), Math.cos(d), 0.1);
    }

    @Test
    public void mockTest() {
        // Мокируем Factorial и SeriesFunction
        Factorial mockFactorial = Mockito.mock(Factorial.class);
        when(mockFactorial.apply(anyLong())).thenAnswer((Answer<Long>) invocation -> {
            Long arg = invocation.getArgument(0);
            return factorial(arg);
        });
        cos.setFACTORIAL(mockFactorial);
        Double x = Math.PI / 3;
        Double result = cos.apply(x);

        // Выполняем простую проверку результата (используем тригонометрическую функцию из Math для сравнения)
        assertEquals(Math.cos(x), result, 0.01, "Calculated cosine does not match the expected value.");
        verify(mockFactorial).apply(0L);
        verify(mockFactorial).apply(2L);
    }

    private long factorial(Long value) {
        if (value <= 1)
            return 1;
        return value * factorial(value - 1);
    }
}
