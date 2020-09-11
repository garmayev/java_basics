
public class Cat
{
    private double originWeight;
    private double weight;

    private static final int EYES_COUNT = 2;
    private static final int MAX_WEIGHT = 9000;
    private static final int MIN_WEIGHT = 1000;

    private static int count;

    private double eat;
    private String name;
    private Color color;

    public Cat()
    {
        this.weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;

        count++;
    }

    public Cat(double weight)
    {
        this.weight = originWeight = weight;
        count++;
    }

    public Cat(String name) {
        this();
        this.name = name;
    }

    public Cat(String name, double weight)
    {
        this.name = name;
        this.weight = originWeight = weight;
        count++;
    }

    public static Cat getKitten() {
        return new Cat(1100);
    }

    public void setColor( Color color )
    {
        this.color = color;
    }
    public Color getColor() { return this.color; }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        eat += amount;
    }

    public static int getCount()
    {
        return count;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public double eating()
    {
        return eat;
    }

    public void pee()
    {
        weight -= weight / 200;
        System.out.println("Pee");
    }
}