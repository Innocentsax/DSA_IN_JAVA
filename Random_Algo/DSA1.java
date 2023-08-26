package org.example.DSA;

public class DSA1 {
    public static void main(String[] args) {
        String man = areYouPlayingBanjo("Rar");
        System.out.println(man);
    }
    public static String areYouPlayingBanjo(String name) {
        if (name.toUpperCase().startsWith("R")) {
            return name + " play banjo";
        } else {
            return name + " does not play banjo";
        }
    }
}
