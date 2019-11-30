package org.Aleksey.jpaPhoneBook.controller;

import org.Aleksey.jpaPhoneBook.exception.ResourceNotFoundException;
import org.Aleksey.jpaPhoneBook.model.User;
import org.Aleksey.jpaPhoneBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        User newUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        newUser.setName(user.getName());
        newUser.setPhoneBook(user.getPhoneBook());
        User updateUser = userRepository.save(newUser);
        return updateUser;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }
}
