package com.mphasis;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DemoOnZonedDateAndTime {

    public static void main(String[] args) {
        
        ZonedDateTime dateTime = ZonedDateTime.now();
        System.out.println("Current DateTime: " + dateTime);
        System.out.println("Offset: " + dateTime.getOffset());
        System.out.println("Zone: " + dateTime.getZone());

        ZonedDateTime regionDateTime = ZonedDateTime.now(ZoneId.of("Asia/Kathmandu"));
        System.out.println("Kathmandu DateTime: " + regionDateTime);

        int diffSeconds = dateTime.getOffset().getTotalSeconds() - regionDateTime.getOffset().getTotalSeconds();
        int hours = diffSeconds / 3600;
        int minutes = (diffSeconds % 3600) / 60;
        System.out.println("Offset difference: " + hours + " hours " + minutes + " minutes");

        LocalDateTime dateTime2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = dateTime2.atZone(ZoneId.of("Asia/Kolkata"));
        System.out.println("Kolkata DateTime: " + zonedDateTime);

        ZonedDateTime indiaTime = zonedDateTime;
        ZonedDateTime usaTime = indiaTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("India Time: " + indiaTime);
        System.out.println("USA Time: " + usaTime);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm a z");
        String formattedZonedDateTime = indiaTime.format(df);
        System.out.println(formattedZonedDateTime);
        System.out.println(regionDateTime.format(df));
    }
}
