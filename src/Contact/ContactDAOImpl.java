package Contact;

import Model.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactDAOImpl implements ContactDAO {
    private List<Contact> contacts;

    public ContactDAOImpl() {
        contacts = new ArrayList<>();
    }

    @Override
    public boolean addContact(Contact contact) {
        // Check if contact with the same ID already exists
        for (Contact existingContact : contacts) {
            if (existingContact.getId() == contact.getId()) {
                return false; 
            }
        }
        
        // Add the contact
        contacts.add(contact);
        return true; // Contact added successfully
    }

    @Override
    public List<Contact> getAllContacts() {
        return contacts;
    }

    @Override
    public boolean deleteContact(int id) {
        Iterator<Contact> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            Contact contact = iterator.next();
            if (contact.getId() == id) {
                iterator.remove();
                return true; // Contact deleted successfully
            }
        }
        return false; // Contact not found
    }
}
