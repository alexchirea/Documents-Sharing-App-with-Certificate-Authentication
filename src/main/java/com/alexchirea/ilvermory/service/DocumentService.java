package com.alexchirea.ilvermory.service;

import com.alexchirea.ilvermory.model.Document;
import com.alexchirea.ilvermory.model.User;
import com.alexchirea.ilvermory.model.enums.DocumentClassification;
import com.alexchirea.ilvermory.repository.DocumentRepository;
import com.alexchirea.ilvermory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    private DocumentRepository documentRepository;

    private UserRepository userRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository, UserRepository userRepository) {
        this.documentRepository = documentRepository;
        this.userRepository = userRepository;
    }

    public List<Document> findAll() {
        return (List<Document>) documentRepository.findAll();
    }

    public List<Document> findAllByUser(String username) {
        User user = userRepository.findUserByCommonNameEquals(username);
        return documentRepository.findDocumentsByUserEquals(user);
    }

    public List<Document> findAllByUser(User user) {
        return documentRepository.findDocumentsByUserEquals(user);
    }

    public List<Document> findAllByClassification(DocumentClassification documentClassification) {
        return documentRepository.findDocumentsByClassificationEquals(documentClassification);
    }

    public Document save(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> saveAll(List<Document> documents) {
        return (List<Document>) documentRepository.saveAll(documents);
    }

}
