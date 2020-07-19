package com.alexchirea.ilvermory.model;

import com.alexchirea.ilvermory.config.UUIDGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "t_user")
public class User {

    private static final long serialVersionUID = -5696348089890495565L;

    @Id
    @GeneratedValue(generator = UUIDGenerator.generatorName)
    @GenericGenerator(name = UUIDGenerator.generatorName, strategy = "com.alexchirea.ilvermory.config.UUIDGenerator")
    private String id;

    @Column(nullable = false)
    private String commonName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    public User() {
    }

    public User(String commonName, String firstName, String lastName) {
        this.commonName = commonName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String id, String commonName, String firstName, String lastName) {
        this.id = id;
        this.commonName = commonName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getId().equals(user.getId()) &&
                getCommonName().equals(user.getCommonName()) &&
                getFirstName().equals(user.getFirstName()) &&
                getLastName().equals(user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCommonName(), getFirstName(), getLastName());
    }
}
