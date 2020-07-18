package com.example.ilvermory.service;

import com.example.ilvermory.model.User;
import com.example.ilvermory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByCN(String cn) {
        return userRepository.findByCommonNameEquals(cn);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
