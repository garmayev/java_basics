
public class Loader
{
    public static void main(String[] args)
    {
        Cat catVasya = new Cat();
        catVasya.setColor(Color.WHITE);
        Cat catAlisa = new Cat();
        catAlisa.setColor(Color.BLACK);
        Cat catAlex = new Cat();
        catAlex.setColor(Color.GRAY);
        System.out.println(Cat.getCount());
    }
}