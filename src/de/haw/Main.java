package de.haw;

import static de.haw.MensaUtil.ANSI_RED;
import static de.haw.MensaUtil.ANSI_RESET;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int kassen = 3;
        int studenten = 10;
        int dauer = 10;

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

        System.out.println(ANSI_RED + "\n\nDie Mensa wird wieder geschlossen." + ANSI_RESET);

        mensa.kassenSchließen();

        System.out.println(ANSI_RED + "Die Mensa ist geschlossen. Bis zum nächsten Mal!\n\n" + ANSI_RESET);
    }
}
