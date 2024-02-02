/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Contact.ContactDAO;
import Model.Contact;
import View.ContactView;
import java.util.List;
import java.util.Scanner;

public class ContactController {
    private ContactView view;
    private ContactDAO dao;
    private Scanner scanner;

    public ContactController(ContactView view, ContactDAO dao) {
        this.view = view;
        this.dao = dao;
        scanner = new Scanner(System.in);
    }

    public void processUserInput() {
        int choice;
        do {
            view.printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    displayAllContacts();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    view.printMessage("Exiting the program.");
                    break;
                default:
                    view.printMessage("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);
    }

    private void addContact() {
        view.printMessage("Enter full name: ");
        String fullName = scanner.nextLine();
        String[] nameParts = fullName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts.length > 1 ? nameParts[1] : "";
        
        view.printMessage("Enter group: ");
        String group = scanner.nextLine();
        view.printMessage("Enter address: ");
        String address = scanner.nextLine();
        view.printMessage("Enter phone: ");
        String phone = scanner.nextLine();
        int id = 0;
       
        Contact contact = new Contact(id,fullName, group, address, phone, lastName, firstName);


        boolean success = dao.addContact(contact);
        if (success) {
            view.printMessage("Contact added successfully.");
        } else {
            view.printMessage("Failed to add contact.");
        }
    }

    private void displayAllContacts() {
        List<Contact> contacts = dao.getAllContacts();
        view.printContactList(contacts);
    }

    private void deleteContact() {
        view.printMessage("Enter the ID of the contact to delete: ");
        int idToDelete = scanner.nextInt();
        boolean success = dao.deleteContact(idToDelete);
        if (success) {
            view.printMessage("Contact deleted successfully.");
        } else {
            view.printMessage("No contact found with ID: " + idToDelete);
        }
    }
}

