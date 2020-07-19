package com.alexchirea.ilvermory.config;

import com.alexchirea.ilvermory.model.User;
import com.alexchirea.ilvermory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserService userService;

    public void run(ApplicationArguments args) {
        userService.save(new User("WERB3011", "Alex", "C"));
    }
}
