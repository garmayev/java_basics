public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius)
    {
        return Math.PI * Math.pow(radius, 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius)
    {
        // Вопрос: При использовании выражения 4/3 или (double)(4/3)
        return ((double) 4 / 3 * Math.PI * Math.pow(radius, 3));
    }

    public static boolean isTriangleRightAngled(double a, double b, double c)
    {
        return a + b > c & b + c > a & a + c > b;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double p = ( a + b + c) / 2;
        if ( isTriangleRightAngled(a, b, c) ) {
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        return 0;
    }
}
