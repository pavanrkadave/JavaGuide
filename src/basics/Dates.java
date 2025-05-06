package basics;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Dates {

    public static void main(String[] args) {

        // LocalDate and LocalDateTime
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        // UTC Time
        Instant instant = Instant.now();
        System.out.println(instant);


        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(localDateTime.format(formatter));


        LocalDate date = LocalDate.now();
        LocalDate birthday = LocalDate.of(1997, 4, 16);

    }
}
