package org.Aleksey.jpaPhoneBook.service;

import org.Aleksey.jpaPhoneBook.JpaPhoneBookApplication;
import org.Aleksey.jpaPhoneBook.model.Contact;
import org.Aleksey.jpaPhoneBook.model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaPhoneBookApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ContactServiceTest {
    User user1;
    User user2;
    Contact contact1;
    Contact contact2;

    @Autowired
    private ContactService contactService;

    @Before
    public void setUp() throws Exception {
        user1 = new User();
        user1.setName("Pavel");
        user2 = new User();
        user2.setName("Pavel");
        contact1 = new Contact();
        contact1.setUser(user1);
        contact1.setName("Grisha");
        contact1.setNumber(89327364863L);
        contact2 = new Contact();
        contact2.setUser(user2);
        contact2.setName("Ivan");
        contact2.setNumber(87647382564L);
    }

    @Test
    public void getAllContacts() {
        contactService.createContact(contact1);
        contactService.createContact(contact2);
        Assert.assertEquals(2, contactService.getAllContacts().size());
    }

    @Test
    public void createContact() {
        contactService.createContact(contact2);
        Assert.assertEquals(contact2.getName(), contactService.getContact(1L).getName());
        Assert.assertEquals(contact2.getNumber(), contactService.getContact(1L).getNumber());
        Assert.assertEquals(contact2.getUser().getName(), contactService.getContact(1L).getUser().getName());
    }

    @Test
    public void getContact() {
        contactService.createContact(contact1);
        Assert.assertEquals(contact1.getName(), contactService.getContact(1L).getName());
        Assert.assertEquals(contact1.getNumber(), contactService.getContact(1L).getNumber());
        Assert.assertEquals(contact1.getUser().getName(), contactService.getContact(1L).getUser().getName());
    }

    @Test
    public void updateContact() {
        contactService.createContact(contact1);
        contactService.updateContact(1L, contact2);
        Assert.assertEquals(contact2.getName(), contactService.getContact(1L).getName());
        Assert.assertEquals(contact2.getNumber(), contactService.getContact(1L).getNumber());
        Assert.assertEquals(contact2.getUser().getName(), contactService.getContact(1L).getUser().getName());
    }

    @Test
    public void deleteContact() {
        contactService.createContact(contact1);
        contactService.deleteContact(1L);
        Assert.assertEquals(0, contactService.getAllContacts().size());
    }

    @Test
    public void searchContact() {
        contactService.createContact(contact1);
        contactService.createContact(contact2);
        Assert.assertEquals(contact1.getName(), contactService.searchContact(89327364863L).get(0).getName());
    }
}