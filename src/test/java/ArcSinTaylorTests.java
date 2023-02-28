import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tpo.ArcSinTaylor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcSinTaylorTests {

    @ParameterizedTest
    @CsvSource({
            "-0.3,1e-6",
            "0.3,1e-6",
            "0.5,1e-6",
    })
    public void testPutAndGet(double x, double eps) {
        assertEquals(Math.asin(x), ArcSinTaylor.calculateArcSin(x, eps), 0.01);
    }
}
