package garmayev;

public class Main {
    public static void print(String[] array) {
        for ( String word : array )
        {
            System.out.println(word);
        }
    }

    public static String[] inverse(String[] array)
    {
        String buffer = "";
        int length = array.length;
        for ( int i = 0; i < (int) length / 2; i++ ) {
            buffer = array[i];
            array[i] = array[(array.length - 1) - i];
            array[(array.length - 1) - i] = buffer;
        }
        return array;
    }

    public static void main(String[] args) {
        String colors = "каждый охотник желает знать, где сидит фазан";
        print(inverse(colors.split(",?\\s+")));
    }
}
