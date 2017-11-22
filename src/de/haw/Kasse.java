package de.haw;

import java.util.concurrent.Semaphore;

public class Kasse {

    private final int WARTESCHLANGE_MAX = 10;

    private int schlangenlaenge = 0;
    private int kassennummer;
    private Semaphore warteschlange;

    public Kasse(int kassennummer) {
        this.kassennummer = kassennummer;
        warteschlange = new Semaphore(WARTESCHLANGE_MAX,true);
    }

    public void kaufen() throws InterruptedException {
        warteschlange.acquire();

        try {
            bezahlen();
        } finally {
            warteschlange.release();
        }

        schlangeVerringern();
    }

    private void bezahlen() throws InterruptedException {
        Thread.sleep(MensaUtil.getZeitBezahlen());
    }

    public int getSchlangenlaenge() {
        return schlangenlaenge;
    }

    public void schlangeErweitern() {
        schlangenlaenge++;
    }

    public void schlangeVerringern() {
        schlangenlaenge--;
    }
}
