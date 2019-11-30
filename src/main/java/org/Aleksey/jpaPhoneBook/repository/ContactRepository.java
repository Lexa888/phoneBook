package org.Aleksey.jpaPhoneBook.repository;

import org.Aleksey.jpaPhoneBook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
