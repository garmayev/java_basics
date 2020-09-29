package ru.garmayev;

import java.util.Scanner;

public class Main {
    public static String[] parsing(String in) {
        return in.split("\\s+");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] fio = parsing(scanner.nextLine());
        for (int i = 0; i < fio.length; i++) {
            switch (i) {
                case 0:
                    System.out.println("Фамилия: " + fio[i]);
                    break;
                case 1:
                    System.out.println("Имя: " + fio[i]);
                    break;
                case 2:
                    System.out.println("Отчество: " + fio[i]);
                    break;
                default:
                    System.err.println("Unknown indentifier");
            }
//            System.out.println(fio[i]);
        }
    }
}
