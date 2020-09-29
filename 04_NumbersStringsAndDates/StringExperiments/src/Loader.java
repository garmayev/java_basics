import java.util.Scanner;

public class Loader
{
    /**
     * Разбиваем строку на массив с помощью регулярного выражения. Пришлось попгуглить, чтобы найти
     * методы работы с регулярками (Не знаю, подойдет ли такой метод для сдачи Проекта)
     *
     * @param in
     * @return String[]
     */
    public static String[] parse(String in) {
        return in.split("\\D+");
    }

    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        int sum = 0;
        String[] parsing = parse(text);
        for (String s : parsing) {
            /**
             * Проверка на "пустой" элемент. Первый элемент в получившемся массиве пустой, поэтому я
             * решил добавить дополнительную проверку на "пустоту" элемента
             */
            if (!s.isEmpty()) {
                sum += Integer.parseInt(s);
            }
        }
        System.out.println(sum);
    }
}