package dev.Innocent.Section8.MathRandomProject;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class MoreTime {
    public static void main(String[] args) {

        System.setProperty("user.timezone", "America/Los_Angeles");
        System.out.println(ZoneId.systemDefault());

        System.out.println("Number of TZs = " + ZoneId.getAvailableZoneIds().size());
        ZoneId.getAvailableZoneIds().stream()
                .filter(s -> s.startsWith("US"))
                .sorted()
                .map(ZoneId::of)
                .forEach(z -> System.out.println(z.getId() + ": " + z.getRules()));

        Set<String> jdk8Zones = ZoneId.getAvailableZoneIds();
        String[] alternate = TimeZone.getAvailableIDs();
        Set<String> oldway = new HashSet<>(Set.of(alternate));

        oldway.removeAll(jdk8Zones);
        System.out.println(oldway);
        ZoneId bet = ZoneId.of("BET", ZoneId.SHORT_IDS);
        System.out.println(bet);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        Instant instantNow = Instant.now();
        System.out.println(instantNow);

        for(ZoneId z : List.of(
                ZoneId.of("Australia/Sydney"),
                ZoneId.of("Europe/Paris"),
                ZoneId.of("America/New_York")
        )){
            DateTimeFormatter zoneFormat = DateTimeFormatter.ofPattern("z:zzzz");
            System.out.println(z);
            System.out.println("\t" + instantNow.atZone(z).format(zoneFormat));
            System.out.println("\t" + z.getRules().getDaylightSavings(instantNow));
            System.out.println("\t" + z.getRules().isDaylightSavings(instantNow));
        }

        Instant dobInstant = Instant.parse("2020-01-01T08:01:00Z");
        LocalDateTime dob = LocalDateTime.ofInstant(dobInstant, ZoneId.systemDefault());
        System.out.println("Your kid's birthdate, LA time = " + dob.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        ZonedDateTime dobSydney = ZonedDateTime.ofInstant(dobInstant, ZoneId.of("Australia/Sydney"));
        System.out.println("Your Kid's birthdate, Sydney time = " + dobSydney.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        ));

        ZonedDateTime dobHere = dobSydney.withZoneSameInstant(ZoneId.systemDefault());
        System.out.println("Your Kid's birthdate, Sydney time = " + dobHere.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        ));

        ZonedDateTime firstOfMonth = ZonedDateTime.now()
                .with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.printf("First of next Month = %tD %n", firstOfMonth);

        Period timePast = Period.between(LocalDate.EPOCH, dob.toLocalDate());
        System.out.println(timePast);

        Duration timeSince = Duration.between(Instant.EPOCH, dob.toInstant(ZoneOffset.UTC));
        System.out.println(timeSince);
    }
}
