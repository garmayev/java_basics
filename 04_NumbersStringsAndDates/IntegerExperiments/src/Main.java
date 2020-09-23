public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

        System.out.println(sumDigits(12345));
        System.out.println(sumDigits(10));
        System.out.println(sumDigits(5059191));
    }

    public static Integer sumDigits(Integer number)
    {
        int result = 0;
        String num = number.toString();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            result += Character.hashCode(ch) - 48;
        }
        return result;
    }
}
