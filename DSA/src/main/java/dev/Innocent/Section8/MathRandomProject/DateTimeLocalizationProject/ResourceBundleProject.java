package dev.Innocent.Section8.MathRandomProject.DateTimeLocalizationProject;

import java.util.ResourceBundle;

public class ResourceBundleProject {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("BasicText");
        System.out.println(rb.getClass().getName());
        System.out.println(rb.getBaseBundleName());
        System.out.println(rb.keySet());

        System.out.printf("%s %s!%n", rb.getString("hello"), rb.getString("world"));
    }
}
