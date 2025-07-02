package dev.Innocent.Section8.FileOperation.ReadingWithNIO2;

import java.awt.desktop.SystemEventListener;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset());

        Path path = Path.of("fixedWidth.txt");
        try{
            System.out.println(new String(Files.readAllBytes(path)));
            System.out.println("-----------------------------------------");
            System.out.println(Files.readString(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
