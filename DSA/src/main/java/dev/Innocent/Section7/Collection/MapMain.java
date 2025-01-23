package dev.Innocent.Section7.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("Phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-------------------------------------------");

        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact : fullList){
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("-------------------------------------------");
        System.out.println(contacts.get("Charlie Brown"));

        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));

        System.out.println("-------------------------------------------");

    }
}
