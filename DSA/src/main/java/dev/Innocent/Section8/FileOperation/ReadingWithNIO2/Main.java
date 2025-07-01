package dev.Innocent.Section8.FileOperation.ReadingWithNIO2;

import java.awt.desktop.SystemEventListener;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset());
    }
}
