package com.nanlabs.trellomanagement.utils;

import java.util.Random;

public class Utils {

    public static String generateRandomWord() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 5;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    public static String generateRandomNumber() {
        int max = 9999;
        int random_int = (int)Math.floor(Math.random()*(max+1));
        return Integer.valueOf(random_int).toString();
    }
}
