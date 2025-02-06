package org.example.phone;

import java.util.Arrays;

public class TestDaoMain {
    public static void main(String[] args) {
        System.out.println("Тест основных методов DAO для InMemory" + "\n");

        InMemoryContactDao inMemoryContactDao = new InMemoryContactDao();
        Contact contact01 = new Contact( 0, "Aliya", "Bergman", "+79708811718","bergman_alijah28@hotmail.com");
        Contact contact02 = new Contact( 0, "Keili", "Teilor", "+79012478320","kaelyn-taylor76@inbox.ru");
        Contact contact03 = new Contact( 0, "Evgenii", "Levin", "+79306199906","johnny-leyva85@yahoo.com");
        Contact contact04 = new Contact( 0, "Valentin", "Abdulov", "+74869004862","abdul-valentine24@internet.ru");

        inMemoryContactDao.addContact(contact01);
        inMemoryContactDao.addContact(contact02);
        inMemoryContactDao.addContact(contact03);
        inMemoryContactDao.addContact(contact04);

        Contact contact03new = new Contact( 0, "Elena", "Kenni", "+77183126290","helena-kenney70@yahoo.com");
        System.out.println("Номер с id 3 старый \n" + inMemoryContactDao.getContact(3));
        inMemoryContactDao.modifyContact(3, contact03new);
        System.out.println("Номер с id 3 новый \n" + inMemoryContactDao.getContact(3));
        Contact[] contacts = inMemoryContactDao.getAllContact();
        System.out.println("Все записи телефонов \n" + Arrays.toString(contacts));
        System.out.println("КОНЕЦ: Тест основных методов DAO для InMemory" + "\n");
    }
}
