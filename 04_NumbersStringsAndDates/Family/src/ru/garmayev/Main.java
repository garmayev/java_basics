package ru.garmayev;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int status;

    private static final int STATUS_FAMILY = 0;
    private static final int STATUS_NAME = 1;
    private static final int STATUS_SURNAME = 2;

    /**
     * Выбираем из строки фрагмент до ближайшего пробела
     *
     * @param in
     * @return
     */
    public static String parsing(String in) {
        int startIndex = 0;
         // Предохраняемся от ошибки NullException
        if (in != null) {
            int lastIndex = in.trim().indexOf(' ');
            if (lastIndex > 0) {
                return in.trim().substring(startIndex, lastIndex);
            }
            return in.trim();
            /**
             * Насколько "допустИм" такой код? Или правильнее писать что-то наподобие следующего
             *
             ***
             * } else {
             *     return null
             * }
             ***
             */
        }
        return null;
    }

    /**
     * Удаление фрагмента строки
     *
     * @param input
     * @param substring
     * @return
     */
    public static String removeSubstring(String input, String substring) {
        int startIndex = input.indexOf(substring);
         // если удаляемый фрагмент и оригинальная строка равны, тогда возвращем null
        if (substring.equals(input.trim())) {
            return null;
        }
        return input.substring(substring.length(), input.length());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        status = 0;
        String input = scanner.nextLine();
        String substring = parsing(input);

        // Пока существует подстрока
        while (substring != null) {
            switch (status) {
                case STATUS_FAMILY:
                    System.out.println("Фамилия:  " + substring);
                    break;
                case STATUS_NAME:
                    System.out.println("Имя:      " + substring);
                    break;
                case STATUS_SURNAME:
                    System.out.println("Отчество: " + substring);
            }

            // Удаляем фрагмент строки
            input = removeSubstring(input.trim(), substring);
            // Изменяем статус
            status++;
            // Обновляем фрагмент подстроки
            substring = parsing(input);
        }
    }
}
