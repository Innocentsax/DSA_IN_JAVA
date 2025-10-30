package dev.Innocent.refresh;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKeywords {
    public static List<Map.Entry<String,Integer>> top10(String path) throws IOException {
        if (!path.toLowerCase().endsWith(".txt")) {
            throw new IllegalArgumentException("Only .txt files are allowed");
        }
        Map<String,Integer> freq = new HashMap<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String w : line.toLowerCase().split("[^a-z]+")) {
                    if (w.isEmpty()) continue;
                    freq.merge(w, 1, Integer::sum);
                }
            }
        }
        return freq.entrySet().stream()
                .sorted((a,b) -> b.getValue()-a.getValue())
                .limit(10)
                .toList();
    }
}