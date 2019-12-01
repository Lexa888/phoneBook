package org.Aleksey.jpaPhoneBook.repository;

import org.Aleksey.jpaPhoneBook.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
