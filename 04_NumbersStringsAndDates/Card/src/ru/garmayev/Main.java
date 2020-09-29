package ru.garmayev;

import java.util.Scanner;

public class Main {

    public static String searchAndReplaceDiamonds(String text) {
        return text.replaceAll("<(.*)>", "***");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        String input = "Номер кредитной карты <4008 1234 5678> 8912";
        System.out.println(searchAndReplaceDiamonds(input));
    }
}
