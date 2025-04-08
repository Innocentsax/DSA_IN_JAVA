package dev.Innocent.Section8.MathRandomProject.DateTimeProject;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate five5 = LocalDate.of(2025, 4, 5);
        System.out.println(five5);

        LocalDate May5th = LocalDate.of(2025, Month.APRIL, 5);
        System.out.println(May5th);

        LocalDate dat125 = LocalDate.ofYearDay(2025, 125);
        System.out.println(dat125);
    }
}
