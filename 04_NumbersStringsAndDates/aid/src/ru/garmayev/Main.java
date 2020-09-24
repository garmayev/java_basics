package ru.garmayev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int box = scanner.nextInt();
        int boxCount = 1;
//        int box = 29;
        int box = 329;

        int container = (int)Math.ceil((double)box / 27);
        int car = (int)Math.ceil((double)box / (27 * 12));

        for (int i = 1; i <= car; i++) {
            System.out.println("Грузовик " + i);
            for (int j = (i - 1) * 12 + 1; j <= i * 12; j++) {
                if ( j <= container ) {
                    System.out.println("\tКонтейнер " + j);

                    for ( int k = (j - 1) * 27 + 1; k <= j * 27 && k <= box; k++ ){
                        System.out.println("\t\tЯщик " + k);
//                        k++;
                    }
                }
            }
        }
        System.out.println("Необходимо: ");
        System.out.println("\tГрузовиков - " + car);
        System.out.println("\tКонтейнеров - " + container);
    }
}
