package dev.Innocent.Section8.FileOperation.RandomAccess;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final Map<Long, Long> indexedId = new LinkedHashMap<>();
    private static int recordsInFile = 0;

    public static void main(String[] args) {
        BuildStudentData.build("studentDate");
    }
}
