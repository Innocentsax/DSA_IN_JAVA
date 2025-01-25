package dev.Innocent.Section7.Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapViewsMain {
    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("Phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);
    }
}
