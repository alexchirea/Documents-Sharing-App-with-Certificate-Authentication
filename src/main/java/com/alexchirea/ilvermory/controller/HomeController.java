package com.alexchirea.ilvermory.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @PreAuthorize(value = "hasAuthority('ROLE_USER')")
    @GetMapping
    public String getHomePage() {
        return "index";
    }

    @RequestMapping("/404")
    public String accessDenied() {
        return "not-found";
    }

}
