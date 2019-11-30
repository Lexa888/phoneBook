package org.Aleksey.jpaPhoneBook.repository;

import org.Aleksey.jpaPhoneBook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
