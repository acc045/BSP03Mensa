package de.haw;

import java.util.concurrent.Semaphore;

import static de.haw.MensaUtil.ANSI_BLUE;
import static de.haw.MensaUtil.ANSI_RESET;

public class Kasse {

    private int schlangenlaenge = 0;
    private int kassennummer;
    private Semaphore warteschlange;

    public Kasse(int kassennummer) {
        this.kassennummer = kassennummer;
        warteschlange = new Semaphore(1,true);
    }

    public void kaufen(){
        String student = Thread.currentThread().toString();

        System.err.println(ANSI_BLUE + String.format("%s: %s hat sich angestellt.", this, student) + ANSI_RESET);

        try {
            warteschlange.acquire();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.err.println(String.format(ANSI_BLUE + "%s: %s ist nun am bezahlen.", this, student) + ANSI_RESET);

        try {
            bezahlen();

            System.err.println(String.format(ANSI_BLUE + "%s: %s hat erfolgreich bezahlt.", this, student) + ANSI_RESET);
        } finally {
            warteschlange.release();
        }
    }

    private void bezahlen(){
        try {
            Thread.sleep(MensaUtil.getZeitBezahlen());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public int getSchlangenlaenge() {
        return schlangenlaenge;
    }

    public void erhoeheSchlangenlaenge() {
        schlangenlaenge++;
    }

    public void reduziereSchlangenlaenge() {
        schlangenlaenge--;
    }

    @Override
    public String toString() {
        return "Kasse " + Integer.toString(kassennummer);
    }
}
