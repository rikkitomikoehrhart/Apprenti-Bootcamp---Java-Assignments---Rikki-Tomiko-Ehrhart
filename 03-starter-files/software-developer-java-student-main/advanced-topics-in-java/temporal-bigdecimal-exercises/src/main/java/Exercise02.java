import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Exercise02 {

    // LocalTime
    // ========================
    // Complete the numbered tasks below.
    // Open and execute the accompanying tests to confirm your solution is correct.

    // 1. return the current time as a LocalTime
    LocalTime getNow() {
        return LocalTime.now();
    }

    // 2. return 4PM (tea time!) as a LocalTime.
    LocalTime getTeaTime() {
        return LocalTime.of(16, 0);
    }

    // 3. add 12 hours to the time parameter and return the value
    LocalTime add12Hours(LocalTime time) {
        return time.plusHours(12);
    }

    // 4. given a time parameter, return a list of the next 4
    // quarter-hour appointments available after the time.
    // appointment times should not include seconds even if the time parameter does.
    // ignore seconds.
    // Examples:
    // time == 16:07:32
    // appointments == 16:15, 16:30, 16:45, 17:00
    //
    // time == 03:00:01
    // appointments == 03:00, 03:15, 03:30, 03:45
    //
    // time == 04:30:00
    // appointments == 04:30, 04:45, 05:00, 05:15
    List<LocalTime> getQuarterHourAppointments(LocalTime time) {
        int minutes = 15;
        List<LocalTime> appointments = new ArrayList<>();
        time = time.truncatedTo(ChronoUnit.MINUTES);


        if (time.getMinute() % 15 == 0) {
            appointments.add(time);
            appointments.add(time.plusMinutes(minutes));
            appointments.add(time.plusMinutes(minutes * 2));
            appointments.add(time.plusMinutes(minutes * 3));
        } else {
            LocalTime adjustedTime = time.plusMinutes(15 - (time.getMinute() % 15));
            appointments.add(adjustedTime);
            appointments.add(adjustedTime.plusMinutes(minutes));
            appointments.add(adjustedTime.plusMinutes(minutes * 2));
            appointments.add(adjustedTime.plusMinutes(minutes * 3));
        }

        return appointments;
    }
}
