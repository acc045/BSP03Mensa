package de.haw;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) throws InterruptedException {
        int kassen = 1;
        int studenten = 10;
        int dauer = 20;

        System.out.println(ANSI_RED + "Eine neue Mensa Simulation wird gestartet." + ANSI_RESET);
        System.out.println(ANSI_RED + "Anzahl der Kassen:      " + kassen + ANSI_RESET);
        System.out.println(ANSI_RED + "Anzahl der Studenten:   " + studenten + ANSI_RESET);
        System.out.println(ANSI_RED + "Öffnungszeit:           " + dauer + ANSI_RESET);
        System.out.println("\n");

        Mensa mensa = new Mensa(kassen, studenten);

        System.out.println(ANSI_RED + "Die Mensa wird geöffnet." + ANSI_RESET);

        mensa.kassenOeffnen();

        System.out.println(ANSI_RED + "Die Mensa ist jetzt offen. Guten Appetit! \n" + ANSI_RESET);

        Thread.sleep(dauer*1000);

        System.out.println(ANSI_RED + "\n\nDie Mensa wird geschlossen." + ANSI_RESET);

        mensa.kassenSchließen();

        System.out.println(ANSI_RED + "Die Mensa ist geschlossen. Bis zum nächsten Mal!\n\n" + ANSI_RESET);
    }
}
