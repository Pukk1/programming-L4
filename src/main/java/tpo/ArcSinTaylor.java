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

    public static void main(String[] args) {
        double x = 0.5;
        double eps = 1e-6;
        double arcsin = calculateArcSin(x, eps);
        System.out.println("arcsin(" + x + ") = " + arcsin);

        System.out.println(Math.asin(0.5));
    }
}
