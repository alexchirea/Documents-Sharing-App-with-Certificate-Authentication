package com.alexchirea.ilvermory.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User extends BaseEntityModel {

    private static final long serialVersionUID = -4306815897133551835L;

    @Column(nullable = false)
    private String commonName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "role")
    Set<RoleUser> roleUserSet;

    @OneToMany
    @JoinColumn(name = "document_id")
    Set<Document> documents;

    public User() {
    }

    public User(String commonName, String firstName, String lastName) {
        this.commonName = commonName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<RoleUser> getRoleUserSet() {
        return roleUserSet;
    }

    public void setRoleUserSet(Set<RoleUser> roleUserSet) {
        this.roleUserSet = roleUserSet;
    }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getCommonName().equals(user.getCommonName()) &&
                getFirstName().equals(user.getFirstName()) &&
                getLastName().equals(user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommonName(), getFirstName(), getLastName());
    }
}
