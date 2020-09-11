
public class Loader
{
    public static void main(String[] args)
    {
        Cat catVasya = new Cat();
        System.out.println(catVasya.getWeight());
        catVasya.feed(150.0);

        System.out.println(catVasya.getWeight());
        catVasya.pee();
        catVasya.pee();

        System.out.println(catVasya.eating());
    }
}