package ru.garmayev;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static TreeSet<String> emails;
    private static String arg = "";
    private static String command = "";

    public static void parseInputLine(String inputLine)
    {
        String patternString = "([\\w]+)(.*)";
        if ( inputLine.trim().matches(patternString) ) {
            Pattern pattern = Pattern.compile(patternString);
            Matcher matcher = pattern.matcher(inputLine);
            while (matcher.find()) {
                switch (matcher.groupCount()) {
                    case 1:
                        command = matcher.group(1).toUpperCase();
                        break;
                    case 2:
                        command = matcher.group(1).toUpperCase();
                        if ( matcher.group(2) != null ) {
                            arg = matcher.group(2).trim();
                        }
                        break;
                }
            }
        }
    }

    public static void printHelp()
    {
        System.out.println("Домашнее Задание #5.3 (Version 0.0.1)");
        System.out.println("\nСписок команд:");
        System.out.println("\tADD <email> - Добавление нового уникального <email> в список");
        System.out.println("\tLIST - Вывести на экран список уникальных <email>");
        System.out.println("\tHELP - Вывести на экран справку по программе");
        System.out.println("\tEXIT - Завершить работу программы\n");
    }

    public static void printEmails()
    {
        if ( emails.size() > 0 ) {
            int count = 0;
            for (String email : emails) {
                System.out.println(count + " - " + email);
                count++;
            }
        } else {
            System.err.println("Список пуст");
        }
    }

    public static void addEmail()
    {
        if ( arg.matches("[a-zA-Z0-9\\.\\_\\-]+@[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,6}") ) {
            emails.add(arg);
            printEmails();
        } else {
            System.err.println("Неверный формат email");
        }
    }

    public static void clearVariables()
    {
        command = "";
        arg = "";
    }

    public static void main(String[] args)
    {
        emails = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        parseInputLine(input);
        while ( !command.equals("EXIT") ) {
            switch (command) {
                case "ADD":
                    addEmail();
                    break;
                case "LIST":
                    printEmails();
                    break;
                case "HELP":
                    printHelp();
                    break;
            }
            clearVariables();
            parseInputLine(scanner.nextLine().trim());
        }
    }
}
