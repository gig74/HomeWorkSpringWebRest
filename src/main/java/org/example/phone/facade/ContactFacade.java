package org.example.phone.facade;

import org.example.phone.Contact;
import org.example.phone.ContactDao;
import org.example.phone.controller.ContactDto;
import org.springframework.stereotype.Component;

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

    public ContactDto getContact(long contactId) {
        Contact contact = contactDao.getContact(contactId);
        return new ContactDto(contact);
    }

    public ContactDto[] getAllContact() {
        Contact[] contacts = contactDao.getAllContact();
        ContactDto[] contactsDto = Stream.of(contacts).map( o -> new ContactDto(o)).toArray(ContactDto[]::new);
        return contactsDto;
    }

    public ContactDto putContact(long contactId, ContactDto contactDto) {
        Contact contactUpd = contactDto.convertContact();
        Contact contact = contactDao.modifyContact(contactId, contactUpd);
        return new ContactDto(contact);
    }
}
