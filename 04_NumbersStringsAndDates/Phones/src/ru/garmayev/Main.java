package ru.garmayev;

import java.util.Scanner;

public class Main {

    public static String replaceCharAt(String input, int position, char ch) {
        return input.substring(0, position) + ch + input.substring(position+1);
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String phone = scanner.nextLine();
        String[] phones = new String[] {"+7 909 123-45-67", "+7 (909) 1234567", "8-905-1234567", "9-453-1234567", "8-905-123", "905-1234567", "8-905-12345672342"};
        for (String phone : phones) {
            String phoneClean = phone.replaceAll("[\\D]", "");
//            System.out.println(phoneClean);
//        StringBuilder sentence = new StringBuilder(phone.replaceAll("[^0-9]", ""));
            if ( phoneClean.matches("^([78]\\d{10})") )
            {
                phoneClean = phoneClean.replaceFirst("^8{1}", "7");
                System.out.println(phoneClean);
            } else if ( phoneClean.matches(("^([9]\\d{9})")) ) {
                phoneClean = "7" + phoneClean;
                System.out.println(phoneClean);
            } else {
                System.err.println("Неверный формат номера: " + phoneClean);
            }
        }
    }
}
