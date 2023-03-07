package L3.tpo;

public class ArcSinTaylor {

    public static double calculateArcSin(double x, double eps) {
        if (x < -1 || x > 1) {
            throw new IllegalArgumentException("x cannot be less than 1 or greater than 1");
        }

        double result = 0;
        double term = x;
        int i = 1;

        while (Math.abs(term) > eps) {
            result += term;
            term *= ((double) (2 * i - 1) * x * x) / ((double) 2 * i * (2 * i + 1));
            i++;
        }

        return result;
    }
}
