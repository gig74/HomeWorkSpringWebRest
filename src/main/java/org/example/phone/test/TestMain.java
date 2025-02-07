package org.example.phone.test;

import org.example.phone.Contact;
import org.example.phone.ContactDao;
import org.example.phone.InMemoryContactDao;
import org.example.phone.controller.ContactController;
import org.example.phone.controller.ContactDto;
import org.example.phone.exceptions.ContactNotFound;
import org.example.phone.facade.ContactFacade;

import java.util.Arrays;
import java.util.List;

public class TestMain {
    public static void main(String[] args) throws ContactNotFound {

        Contact contact01 = new Contact( 0, "Aliya", "Bergman", "+79708811718","bergman_alijah28@hotmail.com");
        Contact contact02 = new Contact( 0, "Keili", "Teilor", "+79012478320","kaelyn-taylor76@inbox.ru");
        Contact contact03 = new Contact( 0, "Evgenii", "Levin", "+79306199906","johnny-leyva85@yahoo.com");
        Contact contact04 = new Contact( 0, "Valentin", "Abdulov", "+74869004862","abdul-valentine24@internet.ru");
        Contact contact03new = new Contact( 0, "Elena", "Kenni", "+77183126290","helena-kenney70@yahoo.com");

        ContactDto contactDto01 = new ContactDto(contact01);
        ContactDto contactDto02 = new ContactDto(contact02);
        ContactDto contactDto03 = new ContactDto(contact03);
        ContactDto contactDto04 = new ContactDto(contact04);
        ContactDto contactDto03new = new ContactDto(contact03new);

        System.out.println("Тест основных методов DAO для InMemory" + "\n");

        InMemoryContactDao inMemoryContactDao = new InMemoryContactDao();

        inMemoryContactDao.addContact(contact01);
        inMemoryContactDao.addContact(contact02);
        inMemoryContactDao.addContact(contact03);
        inMemoryContactDao.addContact(contact04);

        System.out.println("Номер с id 3 старый \n" + inMemoryContactDao.getContact(3));
        inMemoryContactDao.modifyContact(3, contact03new);
        System.out.println("Номер с id 3 новый \n" + inMemoryContactDao.getContact(3));
        List<Contact> contacts = inMemoryContactDao.getAllContact();
        System.out.println("Все записи телефонов \n" + Arrays.toString(contacts.toArray()));
        inMemoryContactDao.clearAllContacts();

        System.out.println("КОНЕЦ: Тест основных методов DAO для InMemory" + "\n" + "\n" + "\n");

        System.out.println("Тест основных методов DTO для InMemory" + "\n");

        ContactDao contactDao = new InMemoryContactDao();
        ContactFacade contactFacade = new ContactFacade(contactDao);

        contactFacade.createContact(contactDto01);
        contactFacade.createContact(contactDto02);
        contactFacade.createContact(contactDto03);
        contactFacade.createContact(contactDto04);

        System.out.println("Номер с id 3 старый \n" + contactFacade.getContact(3));
        contactFacade.putContact(3, contactDto03new);
        System.out.println("Номер с id 3 новый \n" + contactFacade.getContact(3));
        List<ContactDto> contactsDto = contactFacade.getAllContact();
        System.out.println("Все записи телефонов \n" + Arrays.toString(contactsDto.toArray()));
        contactFacade.clearAllContacts();

        System.out.println("КОНЕЦ: Тест основных методов DTO для InMemory" + "\n" + "\n" + "\n");

        System.out.println("Тест основных методов Контроллера для InMemory" + "\n");

        ContactController contactController = new ContactController(contactFacade);

        contactController.createContact(contactDto01);
        contactController.createContact(contactDto02);
        contactController.createContact(contactDto03);
        contactController.createContact(contactDto04);

        System.out.println("Номер с id 3 старый \n" + contactController.getContact(3));
        contactController.putContact(3, contactDto03new);
        System.out.println("Номер с id 3 новый \n" + contactController.getContact(3));
        List<ContactDto> contactsController = contactController.getAllContact();
        System.out.println("Все записи телефонов \n" + Arrays.toString(contactsController.toArray()));

        System.out.println("КОНЕЦ: Тест основных методов Контроллера для InMemory" + "\n");
    }
}
