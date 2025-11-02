package com.campusdual.classroom;

import com.campusdual.Utils;

public class Exercise {
    public static void main(String[] args) {
        Contact c1 = new Contact("Javier", "López", "123-345-121");
        Contact c2 = new Contact("Carlos", "Fernández-Simón", "111-222-333");
        Contact c3 = new Contact("José Manuel", "Soria", "222-555-666");
        Phonebook p = new Phonebook();

        p.addContact(c1);
        p.addContact(c2);
        p.addContact(c3);

        int option;

        do {
            System.out.println("\n=======   Hi there! Welcome!   =======");
            System.out.println("Please, type the option you want: ");
            System.out.println("\nPress 1 to ADD a new contact");
            System.out.println("Press 2 to view your CONTACT LIST");
            System.out.println("Press 3 to REMOVE a contact");
            System.out.println("Press 4 to VIEW a contact");
            System.out.println("Press 5 to EXIT");
            option = Utils.integer("\nPlease, choose an option: ");

            switch (option) {
                case 1:
                    Contact c = new Contact(Utils.string("Enter first name(s): "), Utils.string("Enter last name(s): "),
                            Utils.string("Enter phone number: "));

                    p.addContact(c);
                    break;
                case 2:
                    p.showPhonebook();
                    break;
                case 3:
                    p.deleteContact(Utils.string("Please enter the contact's identifier: "));
                    break;
                case 4:
                    p.getContact(Utils.string("Please enter the contact's identifier: "));
                    break;
                case 5:
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Please type a valid option: ");
                    break;
            }
        } while (option != 5);
    }
}
