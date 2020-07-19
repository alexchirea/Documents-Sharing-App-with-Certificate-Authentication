package com.alexchirea.ilvermory.config;

import com.alexchirea.ilvermory.model.Role;
import com.alexchirea.ilvermory.model.RoleUser;
import com.alexchirea.ilvermory.model.User;
import com.alexchirea.ilvermory.service.RoleService;
import com.alexchirea.ilvermory.service.RoleUserService;
import com.alexchirea.ilvermory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements ApplicationRunner {

    private UserService userService;
    private RoleService roleService;
    private RoleUserService roleUserService;

    @Autowired
    public DataLoader(UserService userService, RoleService roleService, RoleUserService roleUserService) {
        this.userService = userService;
        this.roleService = roleService;
        this.roleUserService = roleUserService;
    }

    public void run(ApplicationArguments args) {
        Role oRoleUser = roleService.save(new Role("ROLE_USER"));
        Role oRoleAdmn = roleService.save(new Role("ROLE_ADMIN"));
        User oUser = userService.save(new User("WERB3011", "Alex", "C"));
        roleUserService.save(new RoleUser(oUser, oRoleUser));
        roleUserService.save(new RoleUser(oUser, oRoleAdmn));
    }
}
