package com.darshan.assignment_three;

import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomStringGenerator {

    private static final String uppercaseAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String lowercaseAplha = uppercaseAlpha.toLowerCase(Locale.ROOT);

    private static final String digits = "0123456789";

    private static final String alphaNumCombination = uppercaseAlpha + lowercaseAplha + digits;


    // Generates a random alpha-numeric string of the specified length.
    public static String generateRandomString(int length) {
        try {
            Random random = new Random();

            // Generate a random string by mapping random integers to characters in the alpha-numeric combination and joining them together
            String randomString;
            randomString = random.ints(length, 0, alphaNumCombination.length())
                    .mapToObj(alphaNumCombination::charAt)
                    .map(Object::toString)
                    .collect(Collectors.joining());

            return randomString;
        }catch (Exception e) {
            // Handle any other exceptions that may occur during string generation
            System.out.println("Error generating random string: " + e.getMessage());
            return  null;

        }
    }

    public static void main(String[] args) {

        try {
            // Length of the random string
            int length = 16;
            String randomString = generateRandomString(length);
            System.out.println("Random alpha-numeric string of 16 digit: " + randomString);
        }
        catch (Exception e) {
            System.out.println("Invalid string length specified.");
        }
    }


}
