import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Exercise05 {

    // THE GODMOTHER
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. Your Godmother gives you $10 every other Friday throughout the year.
    // Payments start on the first Friday of the year.
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateGiftsTilEndOfYear(LocalDate date) {
        LocalDate firstDayOfYear = LocalDate.of(date.getYear(), 1, 1);
        LocalDate lastDayOfYear = date.with(TemporalAdjusters.lastDayOfYear());

        LocalDate friday;

        if (firstDayOfYear.getDayOfWeek() == DayOfWeek.FRIDAY) {
            friday = firstDayOfYear;
        } else {
            friday = firstDayOfYear.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }

        int totalPayDays = 0;

        while (!friday.isAfter(lastDayOfYear)) {
            if (friday.isAfter(date)) {
                totalPayDays += 1;
            }

            friday = friday.plusWeeks(2);
        }

        BigDecimal totalPay = BigDecimal.valueOf(totalPayDays).multiply(BigDecimal.TEN);

        return totalPay;
    }

    // 2. Your Godmother is getting quirky. She adjusted her payment schedule.
    // She still pays every other Friday throughout the year, starting on the first Friday of the year.
    // But now, she pays a number of dollars equal to the day of the month.
    // Examples
    // Jan 31 == $31
    // Mar 1 == $1
    // July 12 == $12
    // Given a date, calculate payments expected from that date until the end of the year.
    BigDecimal calculateQuirkyGiftsTilEndOfYear(LocalDate date) {
        LocalDate firstDayOfYear = LocalDate.of(date.getYear(), 1, 1);
        LocalDate lastDayOfYear = date.with(TemporalAdjusters.lastDayOfYear());

        LocalDate friday;

        if (firstDayOfYear.getDayOfWeek() == DayOfWeek.FRIDAY) {
            friday = firstDayOfYear;
        } else {
            friday = firstDayOfYear.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        }

        BigDecimal total = BigDecimal.ZERO;

        while (!friday.isAfter(lastDayOfYear)) {
            if (friday.isAfter(date)) {
                total = total.add(BigDecimal.valueOf(friday.getDayOfMonth()));
            }

            friday = friday.plusWeeks(2);
        }

        return total;
    }

}
