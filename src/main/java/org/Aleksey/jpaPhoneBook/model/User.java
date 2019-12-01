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
    @Column(name = "id_user", nullable=false, unique=true)
    private Long idUser;
    @Column(name = "name_user", nullable = false)
    private String nameUser;
    @OneToMany(mappedBy="user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Set<Contact> phoneBook;


    public Long getId() {
        return idUser;
    }

    public void setId(Long id) {
        this.idUser = id;
    }

    public String getName() {
        return nameUser;
    }

    public void setName(String name) {
        this.nameUser = name;
    }

    public Set<Contact> getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(Set<Contact> phoneBook) {
        this.phoneBook = phoneBook;
    }
}
