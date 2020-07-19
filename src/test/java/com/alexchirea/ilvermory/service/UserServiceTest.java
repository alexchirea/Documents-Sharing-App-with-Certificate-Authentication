package com.alexchirea.ilvermory.service;

import com.alexchirea.ilvermory.data.TestDataUsers;
import com.alexchirea.ilvermory.repository.UserRepository;
import com.alexchirea.ilvermory.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    private TestDataUsers testDataUsers = new TestDataUsers();

    @BeforeEach
    void setUp() {
        userRepository.saveAll(testDataUsers.getUsers());
    }

    @Test
    void findByCN() {
        User result = userRepository.findUserByCommonNameEquals(testDataUsers.aCommonNames.get(0));
        assertEquals(result.getCommonName(), testDataUsers.aCommonNames.get(0));
        assertEquals(result.getFirstName(), testDataUsers.aFirstNames.get(0));
        assertEquals(result.getLastName(), testDataUsers.aLastNames.get(0));
    }

    @Test
    void save() {
        User oUser = new User("XYZ", "J", "Smith");
        User result = userRepository.save(oUser);
        assertEquals(result.getCommonName(), "XYZ");
        assertEquals(result.getFirstName(), "J");
        assertEquals(result.getLastName(), "Smith");
    }
}