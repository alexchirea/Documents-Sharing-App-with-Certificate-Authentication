package com.alexchirea.ilvermory.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/docs")
public class DocsController {

    @PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
    @GetMapping
    public String getDocsPage() {
        return "docs";
    }

}
