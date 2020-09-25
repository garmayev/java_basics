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
