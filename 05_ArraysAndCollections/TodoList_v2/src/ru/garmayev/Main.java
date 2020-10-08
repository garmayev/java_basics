package ru.garmayev;

import garmayev.Tools;
import ru.garmayev.classes.TodoList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {
    public static void manual()
    {
        System.out.println("Программа \"Задачник\"\n");
        System.out.println("\tДанная программа реализована в рамках учебного курса \"Java-разработчик c нуля\".");
        System.out.println("\tМодуль 5, домашнее задание 2\n");
        System.out.println("\tСписок допустимых команд: ");
        System.out.println("\t\tADD <index> <text>  - Добавление новой задачи в список");
        System.out.println("\t\t\t\t\t<index> - Число, указывающее позицию для добавления новой задачи. Если <index> больше общей длины всего списка, то задача добавится в конец спика");
        System.out.println("\t\t\t\t\t<text>  - Текст заголовка для новой задачи\n");
        System.out.println("\t\tADD <text>          - Добавление новой задачи в список");
        System.out.println("\t\t\t\t\t<text>  - Текст заголовка для новой задачи. В данном случае задача добавится в конец списка\n");
        System.out.println("\t\tEDIT <index> <text> - Редактирование существующей задачи");
        System.out.println("\t\t\t\t\t<index> - Число, указывающее позицию для редактирования задачи. Если <index> больше общей длины всего списка, то произойдет ошибка и программа вас оповестит об этом");
        System.out.println("\t\t\t\t\t<text>  - Текст заголовка для новой задачи\n");
        System.out.println("\t\tDELETE <index>      - Удаление задачи из списка");
        System.out.println("\t\t\t\t\t<index> - Число, указывающее позицию для удаления задачи. Если <index> больше общей длины всего списка, то произойдет ошибка и программа вас оповестит об этом\n");
        System.out.println("\t\tLIST                - Вывод списка всех задач\n");
        System.out.println("\t\tHELP                - Вывод справки по программе\n");
        System.out.println("\t\tEXIT                - Завершение работы программы\n");
    }

    public static String[] parseCommandLine(String input)
    {
        int[] regex_limit = new int[]{1, 2, 3, 2};
        String[] regexes = new String[]{"(\\w+)", "(\\w+)\\s+(\\d+)", "(\\w+)\\s+(\\d+)\\s+(.*)", "(\\w+)\\s+(.*)"};

        for (int i = 0; i < regexes.length; i++) {
            if (input.matches(regexes[i])) {
                return input.split("\\s+", regex_limit[i]);
            }
        }
        return new String[]{};
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        TodoList todo = new TodoList();
        for (;;)
        {
            String inputCommand = scanner.nextLine();
            String[] commands = parseCommandLine(inputCommand.trim());
            if (commands.length > 0) {
                switch (commands[0].toLowerCase()) {
                    case "add":
                        if (commands.length == 3) {
                            if ( todo.add(Integer.parseInt(commands[1]), commands[2]) )
                            {
                                System.out.println("Задача успешно добавлена");
                                todo.list();
                            } else {
                                System.err.println(todo.error.toString());
                            }
                        } else {
                            if ( todo.add(commands[1]) )
                            {
                                System.out.println("Задача успешно добавлена");
                                todo.list();
                            } else {
                                System.err.println(todo.error.toString());
                            }
                        }
                        break;
                    case "edit":
                        if ( todo.edit(Integer.parseInt(commands[1]), commands[2]) )
                        {
                            System.out.println("Задача успешно изменена");
                            todo.list();
                        } else {
                            System.err.println(todo.error.toString());
                        }
                        break;
                    case "delete":
                        if ( todo.delete(Integer.parseInt(commands[1])) )
                        {
                            System.out.println("Задача успешно удалена");
                            todo.list();
                        } else {
                            System.err.println(todo.error.toString());
                        }
                        break;
                    case "list":
                        if ( !todo.list() )
                        {
                            System.err.println(todo.error.toString());
                        }
                        break;
                    case "help":
                        manual();
                    case "exit":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Наизвестная команда");
                        break;
                }
            } else {
                System.out.println("Неизвестная команда или команда не найдена");
            }
        }
    }
}
