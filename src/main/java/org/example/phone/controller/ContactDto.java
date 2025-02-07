package org.example.phone.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.phone.Contact;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class ContactDto {
    @JsonProperty("contactId")
    private long contactId;
    @JsonProperty("name")
    @NotNull
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("phone")
    @NotNull
    @Pattern(regexp = "^\\s?((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[\\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?\\s?", message = "  Неверный номер телефона ")
    private String phone;
    @JsonProperty("email")
    @Email
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

    @Override
    public String toString() {
        return "ContactDto{" +
                "contactId=" + contactId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactDto that = (ContactDto) o;

        if (contactId != that.contactId) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(surname, that.surname)) return false;
        if (!Objects.equals(phone, that.phone)) return false;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        int result = (int) (contactId ^ (contactId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
