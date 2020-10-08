package garmayev;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> todoList;
    private static String command;
    private static int index;
    private static String name;

    private static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void add() {
        todoList.add(index, name);
    }

    public static void delete()
    {
        todoList.remove(index);
    }

    public static void edit()
    {
        todoList.set(index, name);
    }

    public static void list()
    {
        int count = 0;
        if ( todoList.size() > 0 ) {
            for (String item : todoList) {
                System.out.println(count + " - " + item);
            }
        } else {
            System.err.println("Список задач пуст");
        }
    }

    public static void help()
    {
        System.out.println("Программа \"Задачник\"");
        System.out.println("\tADD <title> - Добавление новой задачи в конец списка с содержимым <title>");
        System.out.println("\tADD <index> <title> - Добавление новой задачи под индексом <index> с содержимым <title>");
        System.out.println("\tEDIT <index> <title> - Изменение задачи под индексом <index> заменой содержимого <title>");
        System.out.println("\tDELETE <index> - Удаление задачи под индексом <index>");
    }

    public static void parseCommand(String line)
    {
        System.out.println(line.replaceAll("(\\W+)"));
//        String[] commands = line.split(" ");
//        switch (commands.length) {
//            case 1:
//                command = commands[0];
//                break;
//            case 2:
//                command = commands[0];
//                if (isInteger(commands[1])) {
//                    index = Integer.parseInt(commands[1]);
//                } else {
//                    name = commands[1];
//                }
//                break;
//            case 3:
//                command = commands[0];
//                if ( isInteger(commands[1]) )
//                {
//                    index = Integer.parseInt(commands[1]);
//                    name = commands[2];
//                }
//                break;
//            default:
//                System.out.println("Ошибка ввода\nВведите HELP для получения справки");
//                break;
//        }
    }

    public static void main(String[] args) {
        todoList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Задачник.");
        System.out.println("Введите HELP, чтобы получить справку");
        parseCommand(scanner.nextLine());
        while (!command.equals("EXIT")) {
//            System.out.println(command + " " + index + " " + name);
            switch (command.toUpperCase()) {
                case "ADD":
                    if ( index != 0 && !name.equals("") ) {
                        add();
                    }
                    break;
                case "DELETE":
                    if ( index != 0 ) {
                        delete();
                    }
                    break;
                case "HELP":
                    help();
                    break;
                case "EDIT":
                    if ( index != 0 && !name.equals("") ) {
                        edit();
                    }
                    break;
                case "LIST":
                    list();
                    break;
                default:
                    System.out.println("Ошибка ввода!\nНеизвестная команда\nВведите HELP для получения справки по программе");
                    break;
            }
            parseCommand(scanner.nextLine());
        }
    }
}
