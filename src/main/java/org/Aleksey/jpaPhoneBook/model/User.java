package org.Aleksey.jpaPhoneBook.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Set;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false, unique=true)
    private Long id;
    @Column(name = "userName", nullable = false)
    private String name;
    @OneToMany(mappedBy="users", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Contact> phoneBook;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(Set<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }
}
