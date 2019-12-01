package org.Aleksey.jpaPhoneBook.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@EntityListeners(AuditingEntityListener.class)
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Long idContact;

    @Column(name = "name_contact", nullable = false)
    private String nameContact;
    @Column(name = "number_contact",nullable = false)
    private Long number;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn (name="user_id")
    private User user;


    public Long getIdContact() {
        return idContact;
    }

    public void setIdContact(Long id) {
        this.idContact = id;
    }

    public String getName() {
        return nameContact;
    }

    public void setName(String name) {
        this.nameContact = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
