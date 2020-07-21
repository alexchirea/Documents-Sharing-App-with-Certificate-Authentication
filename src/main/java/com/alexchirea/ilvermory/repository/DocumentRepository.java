package com.alexchirea.ilvermory.repository;

import com.alexchirea.ilvermory.model.Document;
import com.alexchirea.ilvermory.model.User;
import com.alexchirea.ilvermory.model.enums.DocumentClassification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Serializable> {
    List<Document> findDocumentsByUserEquals(User user);
    List<Document> findDocumentsByClassificationEquals(DocumentClassification documentClassification);
}
