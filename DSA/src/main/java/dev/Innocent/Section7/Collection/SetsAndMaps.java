package dev.Innocent.Section7.Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetsAndMaps {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");

        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContact = new HashSet<>(phones);

        printData("Phone List", phoneContact);
        printData("Email List", emailContacts);

        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists("RHood@sherwoodforest.com", "RHood@sherwoodforest.org");
        System.out.println(robinHood);
    }

    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-----------------------------------------------");
        System.out.println(header);
        System.out.println("------------------------------------------------");
        contacts.forEach(System.out::println);
    }
}
