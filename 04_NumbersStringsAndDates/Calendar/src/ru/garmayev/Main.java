package ru.garmayev;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        /**
         * version 1
         */
//        int day = 10;
//        int month = 3;
//        int year = 1990;
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(year, month, day);
//
//        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
//        DateFormat dayFormat = new SimpleDateFormat("EEEE");
//
//        for (int i = 0; i < 31; i ++) {
//            System.out.println(i + " - " + dateFormat.format(calendar.getTime()) + " - " + dayFormat.format(calendar.getTime()));
//            calendar.add(Calendar.YEAR, 1);
//        }

        /**
         * v1 Update 1 (3.10.2020)
         */
        int day = 10;
        int month = 4;
        int year = 1990;

        int count = 0;

        LocalDate birthday, today;
        birthday = LocalDate.of(year, month, day);
        today = LocalDate.now();

        while (today.isAfter(birthday)) {
            String formattedDate = DateTimeFormatter.ofPattern("dd.MM.yyyy EEEE", new Locale("ru")).format(birthday);
            System.out.println(count + " - " + formattedDate);
            count++;
            birthday = birthday.plusYears(1);
        }
    }
}
