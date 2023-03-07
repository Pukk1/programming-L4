package tpo;

public class ArcSinTaylor {

    public static double calculateArcSin(double x, double eps) {
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
