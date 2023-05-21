package com.darshan.assignment_two;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {
    public static void main(String[] args) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            // Get current local date and time
            LocalDateTime currentLocalDateTime = getCurrentLocalDateTime();

            // Convert local date and time to UTC
            ZonedDateTime utcDateTime = convertToUTC(currentLocalDateTime, ZoneId.systemDefault());

            // Convert UTC date and time back to local date and time
            LocalDateTime convertedLocalDateTime = convertToLocalDateTime(utcDateTime, ZoneId.systemDefault());

            // Print the results
            System.out.println("Current local date and time in your timezone: " + currentLocalDateTime.format(formatter));
            System.out.println("Convert local date and time to UTC  date and time: " + utcDateTime.format(formatter));
            System.out.println();
            System.out.println("UTC date and time: " + formatter.format(utcDateTime));
            System.out.println("Converted local date and time in your timezone:: " + convertedLocalDateTime.format(formatter));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Get the current local date and time
    public static LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    // Convert local date and time to UTC
    public static ZonedDateTime convertToUTC(LocalDateTime localDateTime, ZoneId zoneId) {
        try {
            ZonedDateTime localZoneDateTime = localDateTime.atZone(zoneId);
            ZonedDateTime utcDateTime = localZoneDateTime.withZoneSameInstant(ZoneId.of("UTC"));
            return utcDateTime;
        } catch (Exception e) {
            throw new RuntimeException("Error converting to UTC: " + e.getMessage());
        }
    }

    // Convert UTC date and time to local date and time
    public static LocalDateTime convertToLocalDateTime(ZonedDateTime utcDateTime, ZoneId zoneId) {
        try {
            ZonedDateTime utcZoneDateTime = utcDateTime.withZoneSameInstant(ZoneId.of("UTC"));
            LocalDateTime convertedLocalDateTime = utcZoneDateTime.withZoneSameInstant(zoneId).toLocalDateTime();
            return convertedLocalDateTime;
        } catch (Exception e) {
            throw new RuntimeException("Error converting to local date and time: " + e.getMessage());
        }
    }
}
