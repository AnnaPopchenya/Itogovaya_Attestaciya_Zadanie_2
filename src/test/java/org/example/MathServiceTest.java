package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class MathServiceTest {

    @Test
    void testGetAnswer_DiscriminantNegative() {
        MathService mathService = new MathService();
        assertThrows(NotFoundAnswerException.class, () -> mathService.getAnswer(1, 2, 3));
    }

    @ParameterizedTest
    @CsvSource({
            "1, -2, 1, 1.0, 1.0",
            "1, -5, 6, 3.0, 2.0"
    })
    void testGetAnswer_Parametrized(int a, int b, int c, double expectedRoot1, double expectedRoot2) throws NotFoundAnswerException {
        MathService mathService = new MathService();
        Pair result = mathService.getAnswer(a, b, c);
        assertNotNull(result);
        assertEquals(expectedRoot1, result.first, 0.001);
        assertEquals(expectedRoot2, result.second, 0.001);
    }

    @Test
    void testGetD() {
        MathService mathService = new MathService();
        assertEquals(0, mathService.getD(1, -4, 4));
    }
}