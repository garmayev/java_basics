
public class Loader
{
    public static void main(String[] args)
    {
        Cat catVasya = new Cat("Васька");
        System.out.println(Cat.getCount());
        catVasya.feed(9000D);
        System.out.println(Cat.getCount());
        catVasya.feed(100D);
        catVasya.feed(100D);
        catVasya.feed(100D);
        catVasya.feed(100D);
        System.out.println(Cat.getCount());
    }
}