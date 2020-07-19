package com.alexchirea.ilvermory.controller;

import com.alexchirea.ilvermory.service.UserService;
import com.alexchirea.ilvermory.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize(value = "hasAuthority('ROLE_USER')")
    @GetMapping(value = "/profile")
    public String user(Model model, Principal principal) {
        User user = userService.findByCN(principal.getName());
        model.addAttribute("uuid", user.getId());
        model.addAttribute("username", user.getCommonName());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        return "profile";
    }
}
