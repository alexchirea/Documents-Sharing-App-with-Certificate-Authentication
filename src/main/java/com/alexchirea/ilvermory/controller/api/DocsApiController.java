package com.alexchirea.ilvermory.controller.api;

import com.alexchirea.ilvermory.model.Document;
import com.alexchirea.ilvermory.model.enums.DocumentClassification;
import com.alexchirea.ilvermory.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/docs")
public class DocsApiController {

    private DocumentService documentService;

    @Autowired
    public DocsApiController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PreAuthorize(value = "hasAnyAuthority('ROLE_USER', 'ROLE_MOD', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Document>> getAll(HttpServletRequest request) {
        List<Document> documents = new ArrayList<>();
        if (request.isUserInRole("ROLE_USER")) {
            documents = documentService.findAllByClassification(DocumentClassification.OPEN);
        } else if (request.isUserInRole("ROLE_MOD")) {
            documents = documentService.findAllByClassification(DocumentClassification.RESTRICTED);
        } else if (request.isUserInRole("ROLE_ADMIN")) {
            documents = documentService.findAllByClassification(DocumentClassification.CONFIDENTIAL);
        }
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

}
