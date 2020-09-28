package ru.garmayev;

public class Main {

    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            System.out.println(c + " = " + (int)c);
        }
    }
}
