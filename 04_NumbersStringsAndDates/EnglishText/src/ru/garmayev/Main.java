package ru.garmayev;

public class Main {

    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sit amet ligula sit amet ipsum placerat tristique. Praesent vel enim erat. Pellentesque commodo, massa vitae maximus mattis, dolor arcu maximus tortor, vel sodales ex est et lectus. Suspendisse a mauris vitae erat ullamcorper venenatis ac vel libero. Cras augue massa, ultricies ac arcu ac, placerat auctor nunc. Mauris cursus odio non aliquet suscipit. Mauris posuere placerat elit vel aliquam.\n\nVivamus in sollicitudin velit, ac dictum magna. Fusce scelerisque luctus tincidunt. Maecenas eget justo ultrices, imperdiet sapien vel, tincidunt enim. Duis dapibus pharetra enim vel condimentum. Curabitur sagittis, justo malesuada molestie feugiat, elit lectus laoreet diam, non facilisis dui nunc in sapien. Quisque ac blandit purus. Phasellus a lectus ac magna commodo tempus vel ultrices odio. Curabitur turpis sapien, pretium porta metus ac, feugiat dictum est. In iaculis pretium leo porttitor placerat. Integer at mi ac elit malesuada blandit id vitae.";
        String[] words = text.split("\\W+");
        for (String word: words)
        {
            System.out.println(word);
        }
        System.out.println( words.length );
    }
}
