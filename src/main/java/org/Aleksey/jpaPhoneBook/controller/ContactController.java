package org.Aleksey.jpaPhoneBook.controller;


import org.Aleksey.jpaPhoneBook.exception.ResourceNotFoundException;
import org.Aleksey.jpaPhoneBook.model.Contact;
import org.Aleksey.jpaPhoneBook.repository.ContactRepository;
import org.Aleksey.jpaPhoneBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactService contactService;


    @GetMapping()
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }
    @PostMapping()
    public Contact createContact(@RequestBody Contact contact){
        return contactService.createContact(contact);
    }
    @GetMapping("/{id}")
    public Contact getContact(@PathVariable("id") Long id){
        return contactService.getContact(id);
    }
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable("id") Long id, @RequestBody Contact contact){
        return contactService.updateContact(id, contact);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Long id){
        return contactService.deleteContact(id);
    }
    @GetMapping("/number={number}")
    public List<Contact> searchContact(@PathVariable("number") Long number){
        return contactService.searchContact(number);
    }

}
