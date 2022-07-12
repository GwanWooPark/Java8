package park.java8.chpater5._02;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) {

        // 기계적인 시간
        Instant instant = Instant.now();
        System.out.println(instant); // 기준 시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.systemDefault()));

        // 사람용 시간
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        ZonedDateTime nowInAmerica = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(nowInAmerica);

        // Period
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = LocalDate.of(2022, Month.OCTOBER, 10);
        Period period = Period.between(today, tomorrow);
        System.out.println(period.getDays());

        // Duration
        Instant durationNow = Instant.now();
        Instant plus = durationNow.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(durationNow, plus);
        System.out.println(between.getSeconds());

        // Formatting
        LocalDateTime localNow = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(localNow.format(MMddyyyy));

        // Parsing
        LocalDate parse = LocalDate.parse("07/12/2022", MMddyyyy);
        System.out.println(parse);

        // 레거시 API
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        System.out.println(dateTime);
    }
}
