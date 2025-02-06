package org.example.phone.controller;

import org.example.phone.facade.ContactFacade;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactFacade contactFacade;
    public ContactController(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }
    @PostMapping
    public ContactDto createAccount(
           @RequestBody ContactDto contactDto
    ) {
        return contactFacade.createContact(contactDto);
    }
    @GetMapping
    public ContactDto[] getAllContact() {
        return contactFacade.getAllContact();
    }
    @GetMapping("/{contactId}")
    public ContactDto getAccount(
            @PathVariable long contactId
    ) {
        return contactFacade.getContact(contactId);
    }

    @PutMapping("/{contactId}")
    public ContactDto putContact(
            @PathVariable long contactId,
            @RequestBody ContactDto contactDto
    ) {
        return contactFacade.putContact(contactId, contactDto);
    }

}
