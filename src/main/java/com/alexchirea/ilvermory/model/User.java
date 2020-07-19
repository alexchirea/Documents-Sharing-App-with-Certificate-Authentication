package com.alexchirea.ilvermory.model;

import com.alexchirea.ilvermory.config.UUIDGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_user")
public class User extends BaseEntityModel {

    private static final long serialVersionUID = -6368037774457761174L;

    @Column(nullable = false)
    private String commonName;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "role")
    Set<RoleUser> roleUserSet;

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
