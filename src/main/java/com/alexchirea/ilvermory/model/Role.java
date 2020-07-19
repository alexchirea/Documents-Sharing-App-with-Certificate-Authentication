package com.alexchirea.ilvermory.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_role")
public class Role extends BaseEntityModel {

    private static final long serialVersionUID = -2615925932286327631L;

    @Column(nullable = false, unique = true)
    private String code;

    @Column
    private String description;

    @OneToMany(mappedBy = "role")
    Set<RoleUser> roleUserSet;

    public Role() {
    }

    public Role(String code) {
        this.code = code;
    }

    public Role(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Role role = (Role) o;
        return getCode().equals(role.getCode()) &&
                Objects.equals(getDescription(), role.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getDescription());
    }
}
