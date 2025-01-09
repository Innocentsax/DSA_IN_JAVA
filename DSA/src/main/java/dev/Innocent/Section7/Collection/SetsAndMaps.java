package dev.Innocent.Section7.Collection;

import java.util.Collection;
import java.util.List;

public class SetsAndMaps {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        printData("Phone List", phones);
        printData("Email List", emails);
    }

    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-----------------------------------------------");
        System.out.println(header);
        System.out.println("------------------------------------------------");
        contacts.forEach(System.out::println);
    }
}
