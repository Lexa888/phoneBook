package org.Aleksey.jpaPhoneBook.service;

import org.Aleksey.jpaPhoneBook.JpaPhoneBookApplication;
import org.Aleksey.jpaPhoneBook.model.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JpaPhoneBookApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceTest {
    User user;
    User user2;
    List<User> userList;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setName("Aleksey");
        user2 = new User();
        user2.setName("Vasya");
        userList = new ArrayList<>();
        userList.add(user);
        userList.add(user2);
    }

    @Test
    public void getAllUsers() {
        userService.createUser(user);
        userService.createUser(user2);
        List<User> users = userService.getAllUsers();
        Assert.assertEquals(2, users.size());
    }

    @Test
    public void createUser() {
        userService.createUser(user);
        Assert.assertEquals("Aleksey", userService.getUser(1L).getName());
    }

    @Test
    public void getUser() {
        userService.createUser(user2);
        Assert.assertEquals("Vasya", userService.getUser(1L).getName());
    }

    @Test
    public void updateUser() {
        userService.createUser(user);
        userService.updateUser(1L, user2);
        Assert.assertEquals("Vasya", userService.getUser(1L).getName());
    }

    @Test
    public void deleteUser() {
        userService.createUser(user);
        userService.deleteUser(1L);
        Assert.assertEquals(0, userService.getAllUsers().size());
    }

    @Test
    public void searchUser() {
        userService.createUser(user);
        Assert.assertEquals("Aleksey", userService.searchUser("leks").get(0).getName());
    }
}