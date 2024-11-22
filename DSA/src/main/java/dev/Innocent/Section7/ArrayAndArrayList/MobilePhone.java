package dev.Innocent.Section7.ArrayAndArrayList;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber, ArrayList<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact already exists.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    private int findContact(String contactName){
        for (int i = 0; i < myContacts.size(); i++) {
            if(myContacts.get(i).getName().equalsIgnoreCase(contactName)){
                return i;
            }
        }
        return -1;
    }

    private Contact queryContact(String contactName){
        int position = findContact(contactName);
        if(position >= 0){
            return myContacts.get(position);
        }
        return null;
    }

    public void printContact(){
        System.out.println("Contact List");
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}