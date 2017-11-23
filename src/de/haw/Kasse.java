package de.haw;

import java.util.concurrent.Semaphore;

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

        System.out.println(Main.ANSI_BLUE + String.format("%s: %s hat sich angestellt.", this, student) + Main.ANSI_RESET);

        schlangenlaenge++;
        warteschlange.acquire();
        schlangenlaenge--;

        System.out.println(String.format(Main.ANSI_BLUE + "%s: %s ist nun am bezahlen.", this, student) + Main.ANSI_RESET);

        try {
            bezahlen();

            System.out.println(String.format(Main.ANSI_BLUE + "%s: %s hat erfolgreich bezahlt.", this, student) + Main.ANSI_RESET);
        } finally {
            warteschlange.release();

            System.out.println(String.format(Main.ANSI_BLUE + "%s: %s hat die Kasse verlassen.", this, student) + Main.ANSI_RESET);
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
