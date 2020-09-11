
public class Loader
{
    public static void main(String[] args)
    {
        Cat catVasya = new Cat();
        Cat catMurka = new Cat();
        Cat catAlisa = new Cat();
        Cat catAlex = new Cat();
        Cat catBarmaley = new Cat();

        System.out.println("Vasya weight before feed: " + catVasya.getWeight());
        catVasya.feed(200.0);
        System.out.println("Vasya weight after feed: " + catVasya.getWeight());
        System.out.println();
        System.out.println("Murka weight before feed: " + catMurka.getWeight());
        catVasya.feed(250.0);
        System.out.println("Murka weight after feed: " + catMurka.getWeight());
        System.out.println();
        System.out.println("Alisa weight before exploded: " + catAlisa.getWeight());
        while (catAlisa.getStatus() != "Exploded") {
            catAlisa.feed(300.0);
        }
        System.out.println(catAlisa.getStatus());
        System.out.println("Alisa weight after exploded: " + catAlisa.getWeight());
        System.out.println();
        System.out.println("Alex weight before dead: " + catAlex.getWeight());
        while (catAlex.getStatus() != "Dead") {
            catAlex.meow();
        }
        System.out.println(catAlex.getStatus());
        System.out.println("Alex weight after dead: " + catAlex.getWeight());

    }
}