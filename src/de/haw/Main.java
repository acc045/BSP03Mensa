package de.haw;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int kassen = 3;
        int studenten = 10;
        int dauer = 20;


        Mensa mensa = new Mensa(kassen, studenten);

        System.out.println("Mensa Start");

        mensa.kassenOeffnen();

        Thread.sleep(dauer*1000);

        System.out.println("Mensa Schluss");

        mensa.kassenSchließen();
    }
}
