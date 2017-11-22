package de.haw;

public class Main {

    public static void main(String[] args) {
        int kassen = 3;
        int studenten = 10;
        int dauer = 5;

        System.out.println("Mensa Start");

        new Mensa(kassen, studenten);

        System.out.println("Mensa Schluss");
    }
}
