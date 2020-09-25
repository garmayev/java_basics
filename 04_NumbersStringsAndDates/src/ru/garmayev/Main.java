package ru.garmayev;

import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
//        minMaxByte();
//        minMaxInt();
//        minMaxShort();
//        minMaxLong();
        minMaxFloat();
        minMaxDouble();
    }

    public static void minMaxByte() {
        System.out.println("Минимальное значение типа Byte");
        System.out.println(Byte.MIN_VALUE);
        System.out.println("Максимальное значение типа Byte");
        System.out.println(Byte.MAX_VALUE);
        System.out.println("=================================================");
        System.out.println();
    }

    public static void minMaxInt() {
        System.out.println("Минимальное значение типа Int");
        System.out.println(Integer.MIN_VALUE);
        System.out.println("Максимальное значение типа Int");
        System.out.println(Integer.MAX_VALUE);
        System.out.println("=================================================");
        System.out.println();
    }

    public static void minMaxShort() {
        System.out.println("Минимальное значение типа Short");
        System.out.println(Short.MIN_VALUE);
        System.out.println("Максимальное значение типа Short");
        System.out.println(Short.MAX_VALUE);
        System.out.println("=================================================");
        System.out.println();
    }

    public static void minMaxLong() {
        System.out.println("Минимальное значение типа Long");
        System.out.println(Long.MIN_VALUE);
        System.out.println("Максимальное значение типа Long");
        System.out.println(Long.MAX_VALUE);
        System.out.println("=================================================");
        System.out.println();
    }

    public static void minMaxFloat() {
        /* Цитата:
         * Float.MIN_VALUE - Константа, содержащая наименьшее ПОЛОЖИТЕЛЬНОЕ НЕНУЛЕВОЕ значение типа float
         * (https://docs.oracle.com/javase/7/docs/api/java/lang/Float.html)
         *
         * Судя по разным источникам в интернете минимальным значением для формата Float и Double является значение
         * -Float.MAX_VALUE, и в принципе это логично, но у меня остается вопрос,  насколько ПРАВИЛЬНО использовать
         * такой метод хранения числа и насколько точно это минимальное значение?
         *
         * По логике минимальное  значение должно быть равно (Float.MAX_VALUE * (-1) + 1), поскольку помимо положи-
         * тельных и отрицательных значений существует одно нейтральное (0)
         *
         * Вопрос по представлению экпоненциального числа в стандартном виде: Как правльно вывести число 4.9E-324 в
         * консоль в стандартном, десятично формате? Пробовал поиграть с форматом  вывода System.out.format, но или
         * это я дурак, или лыжи не едут, или вообще песок не правильный, но число не выводится правльно
         */
        System.out.println("Минимальное значение типа Float");
        System.out.println(Float.MAX_VALUE * (-1));
        System.out.println("Максимальное значение типа Float");
        System.out.println(Float.MAX_VALUE);
        System.out.println("=================================================");
        System.out.println();
    }

    public static void minMaxDouble() {
        System.out.println("Минимальное значение типа Double");
        System.out.println("-" + Double.MAX_VALUE);
        System.out.println("Максимальное значение типа Double");
        System.out.println(Double.MAX_VALUE);
        System.out.println("=================================================");
        System.out.println();
    }
}
