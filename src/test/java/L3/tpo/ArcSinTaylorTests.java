package L3.tpo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tpo.ArcSinTaylor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArcSinTaylorTests {

    @ParameterizedTest
    @CsvSource({
            "-0.3,1e-6,-0.304693",
            "0,1e-6,0",
            "0.3,1e-6,0.304693",
            "0.5,1e-6,0.523599",
    })
    public void testCommonArguments(double x, double eps, double expected) {
        assertEquals(expected, ArcSinTaylor.calculateArcSin(x, eps), 0.01);
    }

    @ParameterizedTest
    @CsvSource({
            "-1.001,1e-6",
            "100,1e-6",
            "1.001,1e-6",
    })
    public void testIllegalArguments(double x, double eps) {
        assertThrows(IllegalArgumentException.class, () -> ArcSinTaylor.calculateArcSin(x, eps));
    }

    @ParameterizedTest
    @CsvSource({
            "0.9999,1e-9,1.55665",
            "-0.9999,1e-9,-1.55665",
    })
    public void testBorderlineArguments(double x, double eps, double expected) {
        assertEquals(expected, ArcSinTaylor.calculateArcSin(x, eps), 0.5);
    }
}
