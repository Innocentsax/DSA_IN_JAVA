package dev.Innocent.Section8.FileOperation.RandomAccess;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final Map<Long, Long> indexedId = new LinkedHashMap<>();
    private static int recordsInFile = 0;

    public static void main(String[] args) {
        BuildStudentData.build("studentDate");
    }

    private static void loadIndex(RandomAccessFile ra, int indexPosition){
        try{
            ra.seek(indexPosition);
            recordsInFile = ra.readInt();
            System.out.println(recordsInFile);
            for(int i = 0; i < recordsInFile; i++){
                indexedId.put(ra.readLong(), ra.readLong());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
