package dev.Innocent.Section8.FileOperation.DataStreams;

import java.io.*;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

    }

    private static void writeData(Path dataFile){
        try(DataOutputStream dataStream = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile.toFile())));
        ) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
