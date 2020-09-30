package ru.garmayev;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        int day = 10;
        int month = 3;
        int year = 1990;

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat dayFormat = new SimpleDateFormat("EEEE");

        for (int i = 0; i < 31; i ++) {
            System.out.println(i + " - " + dateFormat.format(calendar.getTime()) + " - " + dayFormat.format(calendar.getTime()));
            calendar.add(Calendar.YEAR, 1);
        }
    }
}
