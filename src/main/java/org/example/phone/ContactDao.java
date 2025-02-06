package org.example.phone;

import java.util.Optional;

public interface ContactDao {
    Contact addContact(Contact contact);
    Contact getContact(long  contactId);
    Contact[] getAllContact();
    Contact modifyContact(long  contactId, Contact contact);
    Optional<Contact> findContact(long  contactId);
}
