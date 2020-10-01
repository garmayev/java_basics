package ru.garmayev;

import java.util.Scanner;

public class Main {

    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        return text.replaceAll("<(.+?)>", placeholder);
    }

    public static void main(String[] args) {
        String input = "Номер <кредитной или дебетовой> карты <4008 1234 5678> 8912";
        System.out.println(searchAndReplaceDiamonds(input, "*"));
    }
}
