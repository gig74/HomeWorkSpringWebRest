package org.example.phone;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    public Contact getContact(long contactId) {
        return findContact(contactId)
                .orElseThrow(() -> new IllegalArgumentException("Contact not found: " + contactId));
    }

    @Override
    public Contact[] getAllContact() {
        Contact[] contacts = contactIdMap.values().toArray(new Contact[contactIdMap.size()]);
        return contacts;
    }

    @Override
    public Contact modifyContact(long  contactId, Contact newInfoContact) {
        Contact infoContact = getContact(contactId);
        infoContact.setName(newInfoContact.getName());
        infoContact.setSurname(newInfoContact.getSurname());
        infoContact.setPhone(newInfoContact.getPhone());
        infoContact.setEmail(newInfoContact.getEmail());
        return infoContact;
    }
    @Override
    public Optional<Contact> findContact(long contactId) {
        return Optional.ofNullable(contactIdMap.get(contactId));
    }
}
