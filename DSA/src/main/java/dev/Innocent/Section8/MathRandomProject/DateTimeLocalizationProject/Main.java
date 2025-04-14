package dev.Innocent.Section8.MathRandomProject.DateTimeLocalizationProject;

import java.time.ZoneId;
import java.util.Locale;

public class Main {

    private record Employee(String name, Locale locale, ZoneId zone){

        public Employee(String name, String locale, String zone) {
            this(name, Locale.forLanguageTag(locale), ZoneId.of(zone));
        }

        public Employee(String name, Locale locale, String zone) {
            this(name, locale, ZoneId.of(zone));
        }
    }

    public static void main(String[] args) {

    }
}
