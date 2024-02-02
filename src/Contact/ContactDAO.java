/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contact;

/**
 *
 * @author THANH TRUNG
 */
import Model.Contact;

import java.util.List;

public interface ContactDAO {
    boolean addContact(Contact contact);
    List<Contact> getAllContacts();
    boolean deleteContact(int id);
}
