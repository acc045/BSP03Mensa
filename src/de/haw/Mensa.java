package de.haw;

import java.util.ArrayList;

public class Mensa {

    private ArrayList<Kasse> kassen = new ArrayList<>();
    private ArrayList<Student> studenten = new ArrayList<>();

    public Mensa(int kassen, int studenten) {

        for (int i = 0; i < kassen; i++) {
            this.getKassen().add( new Kasse(i));
        }

        for (int i = 0; i < studenten; i++) {
            this.getStudenten().add( new Student(i, this));
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
        for (Student student : studenten) {
            try {
                student.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized ArrayList<Kasse> getKassen() {
        return kassen;
    }

    public synchronized ArrayList<Student> getStudenten() {
        return studenten;
    }
}
