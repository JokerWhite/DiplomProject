package edu.kenzh.diplom.utils;

import java.util.Random;

public class IntegerUtils {
    public static int generateRandomInt (int upperLimit) {
        Random rand = new Random();
        return rand.nextInt(upperLimit);
    }
}
