package org.Aleksey.jpaPhoneBook.service;

import org.Aleksey.jpaPhoneBook.exception.ResourceNotFoundException;
import org.Aleksey.jpaPhoneBook.model.User;
import org.Aleksey.jpaPhoneBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //получение списка всех пользователей
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //создание пользователя
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //получение пользователя по id
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    //редактирование пользователя
    public User updateUser(Long id, User user) {
        User newUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        newUser.setName(user.getName());
        newUser.setPhoneBook(user.getPhoneBook());
        User updateUser = userRepository.save(newUser);
        return updateUser;
    }

    //удаление пользователя
    public ResponseEntity<?> deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
        return ResponseEntity.ok().build();
    }

    //поиск пользователя по имени или его части
    public List<User> searchUser(String name) {
        return userRepository.findUserByName("%" + name + "%");
    }
}
