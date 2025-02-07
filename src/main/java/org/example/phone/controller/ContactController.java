package org.example.phone.controller;

import org.example.phone.exceptions.ContactNotFound;
import org.example.phone.facade.ContactFacade;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactFacade contactFacade;
    public ContactController(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }
    @PostMapping
    public ContactDto createContact(
            @Validated @RequestBody ContactDto contactDto
    ) {
        return contactFacade.createContact(contactDto);
    }
    @GetMapping
    public List<ContactDto> getAllContact() {
        return contactFacade.getAllContact();
    }
    @GetMapping("/{contactId}")
    public ContactDto getContact(
            @PathVariable long contactId
    ) throws ContactNotFound {
        return contactFacade.getContact(contactId);
    }

    @PutMapping("/{contactId}")
    public ContactDto putContact(
            @PathVariable long contactId,
            @Validated @RequestBody ContactDto contactDto
    ) throws ContactNotFound {
        return contactFacade.putContact(contactId, contactDto);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<String> handleApplicationException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

}
