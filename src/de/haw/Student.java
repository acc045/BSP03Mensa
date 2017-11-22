package de.haw;

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
                Kasse kasse = mensa.stelleAnKasseAn();

                kasse.kaufen();

                essen();
            }
        } catch (InterruptedException e) {
        }
    }

    private void essen() throws InterruptedException {
        Thread.sleep(MensaUtil.getZeitEssen());
    }
}
