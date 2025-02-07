package org.example.phone;

import org.example.phone.exceptions.ContactNotFound;

import java.util.*;

public class InMemoryContactDao implements ContactDao {
    private long lastContactId = 1L;
    private final Map<Long, Contact> contactIdMap;

    public InMemoryContactDao() {
        this.contactIdMap = new HashMap<>();
    }

    @Override
    public Contact addContact(Contact contact) {
        contact.setId(lastContactId);
        contactIdMap.put(lastContactId, contact);
        lastContactId++;
        return contact;
    }

    @Override
    public Contact getContact(long contactId) throws ContactNotFound {
        return findContact(contactId)
                .orElseThrow(() -> new ContactNotFound("Contact not found: " + contactId));
    }

    @Override
    public List<Contact> getAllContact() {
        List<Contact>  contacts = contactIdMap.values().stream().toList();
        return contacts;
    }

    @Override
    public Contact modifyContact(long  contactId, Contact newInfoContact) throws ContactNotFound {
        Contact infoContact = getContact(contactId);
        infoContact.setName(newInfoContact.getName());
        infoContact.setSurname(newInfoContact.getSurname());
        infoContact.setPhone(newInfoContact.getPhone());
        infoContact.setEmail(newInfoContact.getEmail());
        return infoContact;
    }

    @Override
    public void clearAllContacts() {
        contactIdMap.clear();
        lastContactId = 1L;
    }

    private Optional<Contact> findContact(long contactId) {
        return Optional.ofNullable(contactIdMap.get(contactId));
    }

}
