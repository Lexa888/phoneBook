package org.Aleksey.jpaPhoneBook.service;

import org.Aleksey.jpaPhoneBook.exception.ResourceNotFoundException;
import org.Aleksey.jpaPhoneBook.model.Contact;
import org.Aleksey.jpaPhoneBook.repository.ContactRepository;
import org.Aleksey.jpaPhoneBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }
    public Contact createContact(Contact contact){
        return contactRepository.save(contact);
    }
    public Contact getContact(Long id){
        return contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
    }
    public Contact updateContact(Long id, Contact contact){
        Contact newContact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
        newContact.setName(contact.getName());
        newContact.setNumber(contact.getNumber());
        newContact.setUser(contact.getUser());

        Contact updateContact = contactRepository.save(newContact);
        return updateContact;
    }
    public ResponseEntity<?> deleteContact(Long id){
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
        contactRepository.delete(contact);
        return ResponseEntity.ok().build();
    }
//    public Contact searchContact(Long number){
//
//    }
}
