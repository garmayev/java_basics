
public class Loader
{
    public static void main(String[] args)
    {
        Cat catVasya = Cat.getKitten();
        System.out.println(catVasya.getWeight());
        Cat catAlisa = Cat.getKitten();
        System.out.println(catAlisa.getWeight());
        Cat catAlex = Cat.getKitten();
        System.out.println(catAlex.getWeight());
        System.out.println(Cat.getCount());
    }
}