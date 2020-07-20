package com.alexchirea.ilvermory.controller;

import com.alexchirea.ilvermory.model.Document;
import com.alexchirea.ilvermory.model.enums.DocumentClassification;
import com.alexchirea.ilvermory.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/docs")
public class DocsController {

    private DocumentService documentService;

    @Autowired
    public DocsController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_USER', 'ROLE_MOD', 'ROLE_ADMIN')")
    @GetMapping
    public String getDocsPage(Model model, Principal principal, HttpServletRequest request) {
        List<Document> documents = new ArrayList<>();
        if (request.isUserInRole("ROLE_USER")) {
            documents = documentService.findAllByClassification(DocumentClassification.OPEN);
        } else if (request.isUserInRole("ROLE_MOD")) {
            documents = documentService.findAllByClassification(DocumentClassification.RESTRICTED);
        } else if (request.isUserInRole("ROLE_ADMIN")) {
            documents = documentService.findAllByClassification(DocumentClassification.CONFIDENTIAL);
        }
        model.addAttribute("documents", documents);
        return "docs";
    }

}
