package ru.garmayev;

import ru.garmayev.aid.Aid;
import java.util.Scanner;

/*
 * Проект "Гуманитарная помощь". Домашнее Задание #4.3 (со звездочкой)
 * Вывел все в отдельный класс для удобства, думал обернуть весь код в
 * блок try-catch, но едиственная(? на мой взгляд) возможная ошибка  -
 * это неверный формат входных  данных,  который  вполне  регулируется
 * методом nextInt()
 *
 */
public class Main {

    public int box;

    public static void main(String[] args) {
        /*
         * Согласен, предыдущий код был более громоздким и неудобочитаемым. Исправил
         */
        System.out.print("Введите количество ящиков: ");
        Scanner scanner = new Scanner(System.in);
        int box = scanner.nextInt();
        Aid aid = new Aid(box);
        System.out.println(aid.toString());
    }
}