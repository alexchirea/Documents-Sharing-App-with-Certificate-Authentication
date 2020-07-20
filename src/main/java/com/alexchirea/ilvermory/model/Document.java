package com.alexchirea.ilvermory.model;

import com.alexchirea.ilvermory.model.enums.DocumentClassification;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_doc")
public class Document extends BaseEntityModel {

    private static final long serialVersionUID = -4437672939561526635L;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private DocumentClassification classification = DocumentClassification.CONFIDENTIAL;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private Integer views = 0;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public Document() {
    }

    public Document(String name, String filePath) {
        this.name = name;
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DocumentClassification getClassification() {
        return classification;
    }

    public void setClassification(DocumentClassification classification) {
        this.classification = classification;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return getName().equals(document.getName()) &&
                Objects.equals(getDescription(), document.getDescription()) &&
                getClassification() == document.getClassification() &&
                getFilePath().equals(document.getFilePath()) &&
                getViews().equals(document.getViews()) &&
                Objects.equals(getUser(), document.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getClassification(), getFilePath(), getViews(), getUser());
    }

}
