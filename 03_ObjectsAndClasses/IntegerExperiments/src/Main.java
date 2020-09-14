public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;
        System.out.println("sumDigits = " + sumDigits1(5059191));
    }

    public static Integer sumDigits2(Integer number)
    {
        String num = number.toString();
        int result = 0;
        for (int i = 0; i < num.length(); i++) result += Character.getNumericValue(num.charAt(i));
        return result;
    }

    /*
     * Метод charAt() возвращает численное значение символа (кодовое
     * обозначение символа). Кодовое значение символа 0 = 48, 1 = 49
     * и т.д.
     *
     * Отсюда  следует,  что  нужно  просто  вычитать  из  переменной
     * num.charAt(i) значение 48
     */
    public static Integer sumDigits1(Integer number)
    {
        String num = number.toString();
        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            result += num.charAt(i) - 48;
        }
        return result;
    }
}
