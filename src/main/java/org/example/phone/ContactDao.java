package org.example.phone;

import org.example.phone.exceptions.ContactNotFound;

import java.util.List;
import java.util.Optional;

public interface ContactDao {
    Contact addContact(Contact contact);
    Contact getContact(long  contactId) throws ContactNotFound;
    List<Contact> getAllContact();
    Contact modifyContact(long  contactId, Contact contact) throws ContactNotFound;
    // Для удобства интеграционного тестирования
    void clearAllContacts();
}
