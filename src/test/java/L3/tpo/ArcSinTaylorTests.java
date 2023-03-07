package L3.tpo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tpo.ArcSinTaylor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcSinTaylorTests {

    @ParameterizedTest
    @CsvSource({
            "-0.3,1e-6,-0.304693",
            "0.3,1e-6,0.304693",
            "0.5,1e-6,0.523599",
    })
    public void testArcSinTaylor(double x, double eps, double expected) {
        assertEquals(expected, ArcSinTaylor.calculateArcSin(x, eps), 0.01);
    }
}
