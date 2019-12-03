package org.Aleksey.jpaPhoneBook.service;

import org.Aleksey.jpaPhoneBook.exception.ResourceNotFoundException;
import org.Aleksey.jpaPhoneBook.model.Contact;
import org.Aleksey.jpaPhoneBook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    //получение списка всех контактов
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    //создание контакта
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    //получение контакта по id
    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
    }

    //редактирование контакта
    public Contact updateContact(Long id, Contact contact) {
        Contact newContact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
        newContact.setName(contact.getName());
        newContact.setNumber(contact.getNumber());
        newContact.setUser(contact.getUser());

        Contact updateContact = contactRepository.save(newContact);
        return updateContact;
    }

    //удаление контакта
    public ResponseEntity<?> deleteContact(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact", "id", id));
        contactRepository.delete(contact);
        return ResponseEntity.ok().build();
    }

    //поиск контакта по номеру
    public List<Contact> searchContact(Long number) {
        return contactRepository.findContactByNumber(number);
    }
}
