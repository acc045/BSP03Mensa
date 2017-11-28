package de.haw;

import java.util.Comparator;

import static de.haw.MensaUtil.ANSI_GREEN;
import static de.haw.MensaUtil.ANSI_RESET;

public class Student extends Thread {

    private int matrikelnummer;
    private Mensa mensa;

    public Student(int matrikelnummer, Mensa mensa) {
        this.matrikelnummer = matrikelnummer;
        this.mensa = mensa;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                System.out.println(String.format("%s sucht die schnellste Kasse.", this));

                Kasse schnellsteKasse = mensa.getKassen().stream().min(
                        Comparator.comparingInt(Kasse::getSchlangenlaenge)).get();

                System.out.println(String.format("%s stellt sich an %s an. ", this, schnellsteKasse));

                schnellsteKasse.kaufen();

                System.out.println(String.format("%s hat etwas an %s gekauft.", this, schnellsteKasse));

                System.out.println(String.format("%s geht jetzt essen.", this));

                essen();

                System.out.println(String.format("%s hat fertig gegessen.", this));
            }
        } catch (InterruptedException e) {
            System.out.println(String.format(ANSI_GREEN + "%s muss wieder in die Vorlesung. (Interrupted)" + ANSI_RESET, this));
        }
    }

    private void essen() throws InterruptedException {
        Thread.sleep(MensaUtil.getZeitEssen());
    }

    @Override
    public String toString() {
        return "Student " + Integer.toString(matrikelnummer);
    }
}
