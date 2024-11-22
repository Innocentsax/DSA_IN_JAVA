package dev.Innocent.Section7.ArrayAndArrayList;

public class Main {
    public static void main(String[] args) {

        MobilePhone mobilePhone = new MobilePhone("0909090909090");

        Contact contact = Contact.createContact("Innocent", "12345678");
        Contact contact2 = Contact.createContact("Innocent2", "123456782");
        Contact contact3 = Contact.createContact("Innocent3", "123456783");

        mobilePhone.addNewContact(contact);
        mobilePhone.addNewContact(contact2);

        mobilePhone.printContact();
        mobilePhone.updateContact(contact2, contact3);
        mobilePhone.printContact();
        mobilePhone.removeContact(contact2);
        mobilePhone.printContact();
    }
}
