package org.example.phone.test;

import org.example.phone.Contact;
import org.example.phone.InMemoryContactDao;
import org.example.phone.exceptions.ContactNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryContactDaoTest {
    InMemoryContactDao inMemoryContactDao;
    Contact contact01 = new Contact( 0, "Aliya", "Bergman", "+79708811718","bergman_alijah28@hotmail.com");
    Contact contact02 = new Contact( 0, "Keili", "Teilor", "+79012478320","kaelyn-taylor76@inbox.ru");
    Contact contact03 = new Contact( 0, "Evgenii", "Levin", "+79306199906","johnny-leyva85@yahoo.com");
    Contact contact04 = new Contact( 0, "Valentin", "Abdulov", "+74869004862","abdul-valentine24@internet.ru");
    @BeforeEach
    void setUp() {
        inMemoryContactDao = new InMemoryContactDao();
    }

    @Test
    void addAndGetContact() throws ContactNotFound {
        inMemoryContactDao.addContact(contact01);
        Contact contactVrf = new Contact( 1, "Aliya", "Bergman", "+79708811718","bergman_alijah28@hotmail.com");
        assertEquals(contactVrf, inMemoryContactDao.getContact(1));
        assertThrows(ContactNotFound.class, () -> inMemoryContactDao.getContact(2));
    }

    @Test
    void getAllContact() {
        inMemoryContactDao.addContact(contact01);
        inMemoryContactDao.addContact(contact02);
        inMemoryContactDao.addContact(contact03);
        assertEquals(3, inMemoryContactDao.getAllContact().size() );
    }

    @Test
    void modifyContact() throws ContactNotFound {
        inMemoryContactDao.addContact(contact01);
        inMemoryContactDao.addContact(contact02);
        inMemoryContactDao.addContact(contact03);
        inMemoryContactDao.addContact(contact04);
        Contact contact03new = new Contact( 0, "Elena", "Kenni", "+77183126290","helena-kenney70@yahoo.com");
        inMemoryContactDao.modifyContact(3, contact03new);
        Contact contactVrf = new Contact( 3, "Elena", "Kenni", "+77183126290","helena-kenney70@yahoo.com");
        assertEquals(contactVrf, inMemoryContactDao.getContact(3));
        Contact contact99new = new Contact( 0, "Bad", "BadNumberContact", "+77183126290","helena-kenney70@yahoo.com");
        assertThrows(ContactNotFound.class, () -> inMemoryContactDao.modifyContact(99, contact99new));
    }

    @Test
    void clearAllContacts() {
        inMemoryContactDao.addContact(contact01);
        inMemoryContactDao.addContact(contact02);
        inMemoryContactDao.addContact(contact03);
        inMemoryContactDao.addContact(contact04);
        inMemoryContactDao.clearAllContacts();
        assertEquals(0, inMemoryContactDao.getAllContact().size() );
    }
}