package org.Aleksey.jpaPhoneBook.service;

import org.Aleksey.jpaPhoneBook.exception.ResourceNotFoundException;
import org.Aleksey.jpaPhoneBook.model.User;
import org.Aleksey.jpaPhoneBook.repository.UserRepository;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
    public User updateUser(Long id, User user) {
        User newUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        newUser.setName(user.getName());
        newUser.setPhoneBook(user.getPhoneBook());
        User updateUser = userRepository.save(newUser);
        return updateUser;
    }
    public ResponseEntity<?> deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
//    public User searchUser(String name){
//        Query query = sessi
//    }
}
