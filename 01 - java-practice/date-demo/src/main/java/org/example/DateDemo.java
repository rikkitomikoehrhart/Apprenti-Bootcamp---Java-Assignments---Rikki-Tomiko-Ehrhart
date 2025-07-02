package org.example;

import org.w3c.dom.ls.LSOutput;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;


public class DateDemo {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        System.out.println("Today: " + today);
        System.out.println("Time: " + time);
        System.out.println("DateTime: " + dateTime);
        System.out.println("OffsetDateTime: " + offsetDateTime);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        System.out.println("Formatted date: " + dateTime.format(formatter));

        DateTimeFormatter czech = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(new Locale("cs", "CZ"));
        System.out.println("Czech date: " + today.format(czech));


        System.out.println("Year: " + today.getYear());
        System.out.println("Month: " + today.getMonthValue());
        System.out.println("Day: " + today.getDayOfMonth());

        LocalDate order = LocalDate.of(2025, 7, 1);
        LocalDate delivery = LocalDate.of(2025, 7, 21);

        long daysBetween = ChronoUnit.DAYS.between(order, delivery);
        System.out.println("Days between order and delivery: " + daysBetween);
    }
}
