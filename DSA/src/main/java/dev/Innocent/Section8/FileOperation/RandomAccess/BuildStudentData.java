package dev.Innocent.Section8.FileOperation.RandomAccess;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public class BuildStudentData {

    public static void build(String datFileName){
        Path studentJson = Path.of("students.json");
        String dataFile = datFileName + ".dat";
        Map<Long, Long> indexedIds = new LinkedHashMap<>();

        try{
            Files.deleteIfExists(Path.of(dataFile));
            String data = Files.readString(studentJson);
            data = data.replaceFirst("^(\\[)", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
