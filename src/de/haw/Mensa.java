package de.haw;

import java.util.ArrayList;
import java.util.Comparator;

public class Mensa {

    private ArrayList<Kasse> kassen = new ArrayList<>();
    private ArrayList<Student> studenten = new ArrayList<>();

    public Mensa(int kassen, int studenten) {

        for (int i = 0; i < kassen; i++) {
            this.getKassen().add( new Kasse(i));
        }

        for (int i = 0; i < studenten; i++) {
            this.getStudenten().add( new Student(2280460+i, this));
        }
    }

    public void kassenOeffnen() {
        for (Student student : studenten) {
            student.start();
        }
    }

    public void kassenSchließen() {
        for (Student student : studenten) {
            student.interrupt();
        }
    }

    public synchronized Kasse stelleAnKasseAn() {
        Kasse schnellsteKasse = getKassen().stream().min(
                Comparator.comparingInt(Kasse::getSchlangenlaenge)).get();

        schnellsteKasse.schlangeErweitern();
        return schnellsteKasse;
    }

    public synchronized ArrayList<Kasse> getKassen() {
        return kassen;
    }

    public synchronized ArrayList<Student> getStudenten() {
        return studenten;
    }
}
