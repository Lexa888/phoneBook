package org.Aleksey.jpaPhoneBook.controller;


import org.Aleksey.jpaPhoneBook.exception.ResourceNotFoundException;
import org.Aleksey.jpaPhoneBook.model.Contact;
import org.Aleksey.jpaPhoneBook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactRepository contactRepository;


    @GetMapping()
    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }
    @PostMapping()
    public Contact createContact(@RequestBody Contact contact){
        return contactRepository.save(contact);
    }
    @GetMapping("/{id}")
    public Contact getContact(@PathVariable("id") Long id){
        return contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
    }
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable("id") Long id, @RequestBody Contact contact){
        Contact newContact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
        newContact.setName(contact.getName());
        newContact.setNumber(contact.getNumber());
        newContact.setUser(contact.getUser());

        Contact updateContact = contactRepository.save(newContact);
        return updateContact;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Long id){
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
        contactRepository.delete(contact);
        return ResponseEntity.ok().build();
    }

}
