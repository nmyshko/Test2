package tests;

public class CalculatorDivision {
    public int divInt(int a, int b) {
        if(b == 0) {
            System.out.println("Деление на ноль запрещено!");
        }
            return a / b;
    }
    public double divDouble(double c, double e) {
//        if(e == 0) {
////            System.out.println("Деление на ноль запрещено!");
//        }
        if(Double.POSITIVE_INFINITY == c / 0) {
            System.out.println("Деление положительного числа на 0");
        }
        if (Double.NEGATIVE_INFINITY == - c / 0) {
            System.out.println("Деление отрицательного числа на 0");
        }
        if (Double.isNaN(0.0/0)) {
            System.out.println("Неопределенность, 0.0/0");
        }
        return c / e;
    }
}