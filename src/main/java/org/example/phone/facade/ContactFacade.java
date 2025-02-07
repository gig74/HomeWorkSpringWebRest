package org.example.phone.facade;

import org.example.phone.Contact;
import org.example.phone.ContactDao;
import org.example.phone.controller.ContactDto;
import org.example.phone.exceptions.ContactNotFound;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ContactFacade {

    private final ContactDao contactDao;

    public ContactFacade(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public ContactDto createContact(ContactDto contactDto) {
        Contact contactIns = contactDto.convertContact();
        Contact contact = contactDao.addContact(contactIns);
        return new ContactDto(contact);
    }

    public ContactDto getContact(long contactId) throws ContactNotFound {
        Contact contact = contactDao.getContact(contactId);
        return new ContactDto(contact);
    }

    public List<ContactDto> getAllContact() {
        List<Contact> contacts = contactDao.getAllContact();
        List<ContactDto> contactsDto = contacts.stream().map(o -> new ContactDto(o)).collect(Collectors.toList());
        return contactsDto;
    }

    public ContactDto putContact(long contactId, ContactDto contactDto) throws ContactNotFound {
        Contact contactUpd = contactDto.convertContact();
        Contact contact = contactDao.modifyContact(contactId, contactUpd);
        return new ContactDto(contact);
    }

    public void clearAllContacts() {
        contactDao.clearAllContacts();
    }
}
