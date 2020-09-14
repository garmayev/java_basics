
public class Loader
{
    public static void main(String[] args)
    {
        Cat catVasya = new Cat("Васька");
        System.out.println(catVasya);
        while (catVasya.getStatus() != "Exploded") { catVasya.feed(300.); }
        Cat catAlisa = Cat.deepClone(catVasya);
        catAlisa.setWeight(3200);
        catAlisa.setName("Алиса");
        System.out.println(catAlisa);
        Cat catAlex = new Cat();
        System.out.println(catAlex.getWeight());
        System.out.println(Cat.getCount());
    }
}