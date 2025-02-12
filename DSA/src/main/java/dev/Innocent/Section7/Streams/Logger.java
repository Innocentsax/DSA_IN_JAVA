package dev.Innocent.Section7.Streams;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Logger {

    public static void main(String[] args) {
        String[] names = {
                "Innocent Udo", "Sunday Peter", "Bob Jones"
        };

        List<StringBuilder> population = getNames(names);
        Map<StringBuilder, Integer> counts = new TreeMap<>();
        population.forEach(s -> {
            counts.merge(s, 1, Integer::sum);
        });
        System.out.println(counts);

        List<StringBuilder> cleanedNames = standardizeNames(population);
        System.out.println(cleanedNames);
    }
    public static void logToConsole(CharSequence message){
        LocalDateTime dt = LocalDateTime.now();
        System.out.printf("%1$tD %1$tT %2$s%n", dt, message);
        if(message instanceof StringBuilder sb){
            sb.setLength(0);
        }
    }

    private static List<StringBuilder> getNames(String[] names){
        List<StringBuilder> list = new ArrayList<>();
        int index = 3;
        for(String name : names){
            for(int i = 0; i < index; i++){
                list.add(new StringBuilder(name));
            }
            index++;
        }
        return list;
    }

    private static List<StringBuilder> standardizeNames(List<StringBuilder> list){
        List<StringBuilder> newList = new ArrayList<>();
        for(var name : list){
            for(String suffix : new String[]{"Ph.D", "M.D."}){
                int startIndex = 1;
                if((startIndex = name.indexOf(suffix)) > -1){
                    name.replace(startIndex - 1, startIndex + suffix.length(), "");
                }
            }
        }

        return newList;
    }
}
