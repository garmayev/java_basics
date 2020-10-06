package ru.garmayev;

import ru.garmayev.classes.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    private static ArrayList<Task> todoList;
    private static String[] commands;

    public static boolean add(String title)
    {
        try {
            todoList.add(new Task(title));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean add(int index, String title)
    {
        try {
            if ( index >= todoList.size() ) {
                todoList.add(new Task(title));
            } else {
                todoList.add(index, new Task(title));
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void list()
    {
        if ( todoList.size() == 0 ) {
            System.err.println("Список пуст");
        }

        int count = 0;
        for ( Task item : todoList )
        {
            System.out.printf("%02d - %s\n", count, item.toString());
            count++;
        }
    }

    public static boolean edit(int index, String title)
    {
        if ( todoList.size() > index ) {
            todoList.set(index, new Task(title));
            return true;
        } else {
            add(title);
        }
        System.err.println("Указанный индекс " + index + " неверен");
        return false;
    }

    public static boolean delete(int index)
    {
        if ( todoList.size() > index ) {
            todoList.remove(index);
            return true;
        }
        System.err.println("Указанный индекс неверен");
        return false;
    }

    public static boolean match(String pattern, String input)
    {
        return false;
    }

    public static ArrayList<String> getCommands(String input)
    {
        ArrayList<String> complete = new ArrayList<>();
        boolean flag = false;
        String[] regex = new String[] {"(\\w+)\\s+(\\d+)\\s+(.+)", "(\\w+)\\s+(\\d+)", "(\\w+)\\s+(.+)", "(\\w+)"};
        for (String reg : regex) {
            Pattern pattern = Pattern.compile(reg);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find() && !flag) {
                switch ( matcher.groupCount() ) {
                    case 1:
                        complete.add(matcher.group(1).toUpperCase());
                        flag = true;
                        break;
                    case 2:
                        complete.add(matcher.group(1).toUpperCase());
                        complete.add(matcher.group(2));
                        flag = true;
                        break;
                    case 3:
                        complete.add(matcher.group(1).toUpperCase());
                        complete.add(matcher.group(2));
                        complete.add(matcher.group(3));
                        flag = true;
                        break;
                }
            }
        }
        return complete;
    }

    public static void main(String[] args) {
        todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (;;) {
            ArrayList<String> commands = getCommands(scanner.nextLine());
            switch (commands.get(0)) {
                case "ADD":
                    boolean saved = ( commands.size() != 2 ) ? add(Integer.parseInt(commands.get(1)), commands.get(2)) : add(commands.get(1));
                    if (saved) {
                        System.out.println("Задача была успешно сохранена");
                    }
                    list();
                    break;
                case "EDIT":
                    if ( edit(Integer.parseInt(commands.get(1)), commands.get(2)) ) {
                        System.out.println("Задача была успешно отредактирована");
                    }
                    list();
                    break;
                case "DELETE":
                    if (delete(Integer.parseInt(commands.get(1)))) {
                        System.out.println("Задача была успешно удалена");
                    }
                    System.out.println("delete " + commands.get(1));
                    list();
                    break;
                case "LIST":
                    list();
                    System.out.println("list all");
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
            }
        }
    }
}
