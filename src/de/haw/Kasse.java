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

    public void kaufen() throws InterruptedException {
        String student = Thread.currentThread().toString();
        schlangenlaenge++;

        System.out.println(ANSI_BLUE + String.format("%s: %s hat sich angestellt.", this, student) + ANSI_RESET);

        warteschlange.acquire();

        System.out.println(String.format(ANSI_BLUE + "%s: %s ist nun am bezahlen.", this, student) + ANSI_RESET);

        try {
            bezahlen();

            System.out.println(String.format(ANSI_BLUE + "%s: %s hat erfolgreich bezahlt.", this, student) + ANSI_RESET);
        } finally {
            schlangenlaenge--;
            warteschlange.release();

            System.out.println(String.format(ANSI_BLUE + "%s: %s hat die Kasse verlassen.", this, student) + ANSI_RESET);
        }
    }

    private void bezahlen() throws InterruptedException {
        Thread.sleep(MensaUtil.getZeitBezahlen());
    }

    public synchronized int getSchlangenlaenge() {
        return schlangenlaenge;
    }

    @Override
    public String toString() {
        return "Kasse " + Integer.toString(kassennummer);
    }
}
