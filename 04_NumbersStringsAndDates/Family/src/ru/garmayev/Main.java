package ru.garmayev;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String family = "Garmayev Bato Alexandrovich";

        System.out.println(family.matches("([\\W]+?)") + "\n");
        String[] items = family.split("[\\W]+?");
        if ( items.length == 3 ) {
            System.out.println("Фамилия: " + items[0] + "\nИмя: " + items[1] + "\nОтчество: " + items[2]);
        } else if ( items.length == 2 ) {
            System.out.println("Фамилия: " + items[0] + "\nИмя: "+items[1]);
        } else if ( items.length == 1 ) {
            System.out.println("Фамилия: " + items[0]);
        } else {
            System.err.println("Неверный формат входных данных");
        }
    }
}
