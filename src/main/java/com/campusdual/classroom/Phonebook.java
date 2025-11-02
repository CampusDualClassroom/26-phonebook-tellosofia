package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Map<String, Contact> contactList;

    public Phonebook() {
        this.contactList = new HashMap<>();
    }

    public void addContact(Contact contact) {
        contactList.put(contact.getCode(), contact);
        System.out.println("The contact was successfully added!");
        System.out.println("Your contacts identifier is: " + contact.getCode());
    }

    public void showPhonebook() {
        if (!contactList.isEmpty()) {
            for (Map.Entry<String, Contact> entry : contactList.entrySet()) {
                System.out.println();
                entry.getValue().showContactDetails();
            }
        } else {
            System.out.println("Your contact list is currently empty!");
        }
    }

    public void deleteContact(String code) {
        if (contactList.containsKey(code)){
            System.out.println("The contact\n");
            contactList.get(code).showContactDetails();
            System.out.println("\nwas successfully deleted!");
            contactList.remove(code);
        } else {
            System.out.println("Contact doesn't exist");
        }
    }

    public Map<String, Contact> getData() {
        return this.contactList;
    }

    public void getContact(String code) {
        if (contactList.containsKey(code)){
            System.out.println("The contact is: \n");
            contactList.get(code).showContactDetails();
        } else {
            System.out.println("Contact doesn't exist");
        }
    }
}
