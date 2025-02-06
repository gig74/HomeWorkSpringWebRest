package org.example.phone.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.phone.Contact;

public class ContactDto {
    @JsonProperty("contactId")
    private long contactId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;

    public ContactDto() {
        super();
    }

    public ContactDto(Contact contact) {
        this.contactId = contact.getId();
        this.name = contact.getName();
        this.surname =  contact.getSurname();
        this.phone =  contact.getPhone();
        this.email =  contact.getEmail();
    }

    public long getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Contact convertContact() {
        Contact contact = new Contact(
                this.contactId,
                this.name,
                this.surname,
                this.phone,
                this.email
        );
        return contact;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) { this.email = email; }
}
