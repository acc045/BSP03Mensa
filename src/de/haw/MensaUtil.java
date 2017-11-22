package de.haw;

import java.util.Random;

public class MensaUtil {

    private static Random random = new Random();

    public static synchronized int getZeitBezahlen() {
        return random.nextInt(1000);
    }

    public static synchronized int getZeitEssen() {
        return random.nextInt(1000) * 3;
    }
}
