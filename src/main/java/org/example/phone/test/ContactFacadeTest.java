package org.example.phone.test;

import org.example.phone.Contact;
import org.example.phone.ContactDao;
import org.example.phone.InMemoryContactDao;
import org.example.phone.controller.ContactDto;
import org.example.phone.exceptions.ContactNotFound;
import org.example.phone.facade.ContactFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactFacadeTest {

    ContactFacade contactFacade;
    ContactDto contact01Dto = new ContactDto(new Contact( 0, "Aliya", "Bergman", "+79708811718","bergman_alijah28@hotmail.com"));
    ContactDto contact02Dto = new ContactDto(new Contact( 0, "Keili", "Teilor", "+79012478320","kaelyn-taylor76@inbox.ru"));
    ContactDto contact03Dto = new ContactDto(new Contact( 0, "Evgenii", "Levin", "+79306199906","johnny-leyva85@yahoo.com"));
    ContactDto contact04Dto = new ContactDto(new Contact( 0, "Valentin", "Abdulov", "+74869004862","abdul-valentine24@internet.ru"));

    @BeforeEach
    void setUp() {
        ContactDao contactDao = new InMemoryContactDao();
        contactFacade = new ContactFacade(contactDao);
    }

    @Test
    void createAndGetContact() throws ContactNotFound {
        contactFacade.createContact(contact01Dto);
        ContactDto contactVrf = new ContactDto(new Contact( 1, "Aliya", "Bergman", "+79708811718","bergman_alijah28@hotmail.com"));
        assertEquals(contactVrf, contactFacade.getContact(1));
        assertThrows(ContactNotFound.class, () -> contactFacade.getContact(2));
    }
    @Test
    void getAllContact() {
        contactFacade.createContact(contact01Dto);
        contactFacade.createContact(contact02Dto);
        contactFacade.createContact(contact03Dto);
        assertEquals(3, contactFacade.getAllContact().size() );
    }

    @Test
    void putContact() throws ContactNotFound {
        contactFacade.createContact(contact01Dto);
        contactFacade.createContact(contact02Dto);
        contactFacade.createContact(contact03Dto);
        contactFacade.createContact(contact04Dto);
        ContactDto contact03new = new ContactDto(new Contact( 0, "Elena", "Kenni", "+77183126290","helena-kenney70@yahoo.com"));
        contactFacade.putContact(3, contact03new);
        ContactDto contactVrf = new ContactDto(new Contact( 3, "Elena", "Kenni", "+77183126290","helena-kenney70@yahoo.com"));
        assertEquals(contactVrf, contactFacade.getContact(3));
        ContactDto contact99new = new ContactDto(new Contact( 0, "Bad", "BadNumberContact", "+77183126290","helena-kenney70@yahoo.com"));
        assertThrows(ContactNotFound.class, () -> contactFacade.putContact(99, contact99new));
    }

    @Test
    void clearAllContacts() {
        contactFacade.createContact(contact01Dto);
        contactFacade.createContact(contact02Dto);
        contactFacade.createContact(contact03Dto);
        contactFacade.createContact(contact04Dto);
        contactFacade.clearAllContacts();
        assertEquals(0, contactFacade.getAllContact().size() );
    }
}