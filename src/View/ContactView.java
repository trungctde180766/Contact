/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Model.Contact;
    import java.util.List;

public class ContactView {
    public void printMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Add a contact");
        System.out.println("2. Display all contacts");
        System.out.println("3. Delete a contact");
        System.out.println("4. Exit");
    }

    public void printContactList(List<Contact> contacts) {
        System.out.println("\nID\tName\t\tFirst Name\tLast Name\tGroup\tAddress\tPhone");
        for (Contact contact : contacts) {
            System.out.printf("%d\t%s\t%s\t\t%s\t\t%s\t%s\t%s%n", contact.getId(), contact.getFullName(),
                    contact.getFirstName(), contact.getLastName(), contact.getGroup(), contact.getAddress(),
                    contact.getPhone());
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}


