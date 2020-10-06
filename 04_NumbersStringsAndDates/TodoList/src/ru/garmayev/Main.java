package ru.garmayev;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ru.garmayev.classes.Task;

public class Main {
    private static ArrayList<Task> todoList;
    private static String command;
    private static int index;
    private static String arg;

    private static boolean isInteger(String string) {
        try {
            int digit = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException var3) {
            return false;
        }
    }

    public static void printHelp() {
        System.out.println("\nСправка:");
        System.out.println("\tADD - Добавить задачу");
        System.out.println("\t\tСинтаксис:");
        System.out.println("\t\tADD <text> - Добавить задачу с текстом <text> в конец списка");
        System.out.println("\t\tADD <index> <text> - Добавить задачу на позицию <index> с текстом <text>");
        System.out.println("\t\t\t\tЕсли значение <index> превосходит длину списка, то задача добавитсяв конец списка");
        System.out.println("\tEDIT - Редактирование задачи");
        System.out.println("\t\tСинтаксис:");
        System.out.println("\t\tEDIT <index> <text> - Текст задачи на позиции <index> замениться значением переменной <text>");
        System.out.println("\tDELETE - Удаление задачи");
        System.out.println("\t\tDELETE <index> - Удаление задачи на позиции <index>");
        System.out.println("\tLIST - Вывести список всех задач");
        System.out.println("\tHELP - Вызов справки");
        System.out.println("\tEXIT - Завершение работы программы");
    }

    public static void printList() {
        if (todoList.size() > 0) {
            for(int i = 0; i < todoList.size(); ++i) {
                System.out.println(i + " - " + ((Task)todoList.get(i)).toString());
            }
        } else {
            System.err.println("Список задач пуст");
        }

    }

    public static void addTask() {
        if (todoList.size() > index) {
            todoList.add(index, new Task(arg));
        } else {
            todoList.add(new Task(arg));
        }

    }

    public static void editTask() {
        if (index < todoList.size()) {
            todoList.set(index, new Task(arg));
        } else {
            todoList.add(new Task(arg));
        }

    }

    public static void deleteTask() {
        if (index < todoList.size()) {
            todoList.remove(index);
        } else {
            System.err.println("Указанный индекс неверен. Проверьте существование записи");
        }

    }

    public static boolean matchesFound(String patternString, String inputLine) {
        boolean result = false;
        Pattern pattern = Pattern.compile(patternString);

        for(Matcher matcher = pattern.matcher(inputLine); matcher.find(); result = true) {
            if (matcher.groupCount() == 3) {
                command = matcher.group(1).toUpperCase();
                index = isInteger(matcher.group(2)) ? Integer.parseInt(matcher.group(2)) : 0;
                arg = matcher.group(3);
            } else if (matcher.groupCount() == 2) {
                command = matcher.group(1).toUpperCase();
                if (isInteger(matcher.group(2))) {
                    index = Integer.parseInt(matcher.group(2));
                } else {
                    arg = matcher.group(2);
                }
            } else if (matcher.groupCount() == 1) {
                command = matcher.group(1).toUpperCase();
            } else {
                System.err.println("Ошибка ввода!\nПроверьте список и синтаксис команд введя HELP");
            }
        }

        return result;
    }

    public static void welcome() {
        System.out.println("Программа \"Задачник\"");
        System.out.println("\tДля получения списка всех команд программы введите help:");
    }

    public static void readCommand() {
        command = "";
        index = 0;
        arg = "";
        String[] patternArray = new String[]{"([a-zA-Z]+) ([0-9]+) ([a-zA-Zа-яА-Я\\-\\_\\,\\.\\s]+)", "([a-zA-Z]+) ([0-9]+)", "([a-zA-Z]+) ([a-zA-Zа-яА-Я\\-\\_\\,\\.\\s]+)", "([a-zA-Z]+)"};
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        String[] var3 = patternArray;
        int var4 = patternArray.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String pattern = var3[var5];
            if (matchesFound(pattern, inputLine)) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        todoList = new ArrayList();
        welcome();
        readCommand();

        for(; !command.equals("EXIT"); readCommand()) {
            String var1 = command;
            byte var2 = -1;
            switch(var1.hashCode()) {
                case 64641:
                    if (var1.equals("ADD")) {
                        var2 = 0;
                    }
                    break;
                case 2123274:
                    if (var1.equals("EDIT")) {
                        var2 = 1;
                    }
                    break;
                case 2213697:
                    if (var1.equals("HELP")) {
                        var2 = 3;
                    }
                    break;
                case 2336926:
                    if (var1.equals("LIST")) {
                        var2 = 4;
                    }
                    break;
                case 2012838315:
                    if (var1.equals("DELETE")) {
                        var2 = 2;
                    }
            }

            switch(var2) {
                case 0:
                    addTask();
                    printList();
                    break;
                case 1:
                    editTask();
                    printList();
                    break;
                case 2:
                    deleteTask();
                    printList();
                    break;
                case 3:
                    printHelp();
                    break;
                case 4:
                    printList();
                    break;
                default:
                    System.out.println(command + " " + index + " " + arg);
                    System.err.println("Ошибка ввода!\nПроверьте список и синтаксис команд введя HELP");
            }
        }

    }
}
