
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

    public static Cat deepClone(Cat original) {
        Cat first = new Cat();
        first.setName( original.getName() );
        first.setColor( original.getColor() );
        first.setWeight( original.getWeight() );
        return first;
    }

    public static Cat getKitten() {
        return new Cat(1100);
    }

    public void setColor( Color color )
    {
        this.color = color;
    }
    public Color getColor() { return this.color; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    public void setWeight(double weight) { this.weight = weight; }
    public double getWeight() { return weight; }

    public void meow()
    {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public boolean isAlive()
    {
        String status = getStatus();
        if ( status != "Dead" && status != "Exploded" )
        {
            return true;
        }
        return false;
    }

    public void feed(Double amount)
    {
        if ( isWeightNormal()) {
            weight = weight + amount;
            eat += amount;
            if (!isAlive()) {
                count--;
            }
        } else {
            System.out.println("Cat can not eating");
        }
    }

    public boolean isWeightNormal() {
        return (weight > MIN_WEIGHT && weight < MAX_WEIGHT);
    }

    public static int getCount()
    {
        return count;
    }

    public void drink(Double amount)
    {
        if ( isWeightNormal() ) {
            weight = weight + amount;
        } else {
            System.out.println("Cat can not drink");
            count--;
        }
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

    public String toString() {
        return "Cat name is " + this.getName() + " and her weight is " + this.getWeight();
    }
}