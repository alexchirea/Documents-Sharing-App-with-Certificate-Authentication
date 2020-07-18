package com.example.ilvermory.controller;

import com.example.ilvermory.model.User;
import com.example.ilvermory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping(value = "/user")
    public String user(Model model, Principal principal) {
        User user = userService.findByCN(principal.getName());
        model.addAttribute("uuid", user.getId());
        model.addAttribute("username", user.getCommonName());
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        return "user";
    }
}
