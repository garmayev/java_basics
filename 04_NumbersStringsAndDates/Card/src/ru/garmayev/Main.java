package ru.garmayev;

import java.util.Scanner;

public class Main {

    public static String searchAndReplaceDiamonds(String text) {
        /*
         * 1. Не получается составить регулярку так, чтобы символы '<' и '>'
         * оставались в оргинальной строке.
         * 2. Не получается составить регулярку  так, чтобы все  выполнялось
         * одним "запросом"
         *
         * Интересный  момент, в  первом  выражении "пробел",  как  я  понял,
         * включается в множество \W (Word?), а во втором выраежении его надо
         * указывать явно (\D - digits, \S - spaces)
         */
        String tmp = text.replaceAll("<[\\W]+>", "*");
        return tmp.replaceAll("<[\\D\\S]+>", "*");
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
        String input = "Номер <кредитной или дебетовой> карты <4008 1234 5678> 8912";
        while (input.indexOf('<') > 0) {
            System.out.println(input.indexOf('<'));
            System.out.println(input);
            input = searchAndReplaceDiamonds(input);
        }
        System.out.println(input);
    }
}
