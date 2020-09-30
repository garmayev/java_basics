package ru.garmayev;

import java.util.Scanner;

public class Main {

    public static String replaceCharAt(String input, int position, char ch) {
        return input.substring(0, position) + ch + input.substring(position+1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();

        StringBuilder sentence = new StringBuilder(phone.replaceAll("[^0-9]", ""));
        try {
            if ( sentence.length() == 11 ) {
                if (sentence.charAt(0) == '8') {
                    sentence.setCharAt(0, '7');
                } else {
                    throw new Exception("Неверный формат номера");
                }
            } else if (sentence.length() == 10){
                sentence.insert(0, '7');
            } else {
                throw new Exception("Неверный формат номера");
            }
            System.out.println(sentence);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
