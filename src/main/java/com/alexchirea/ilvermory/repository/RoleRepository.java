package com.alexchirea.ilvermory.repository;

import com.alexchirea.ilvermory.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RoleRepository extends CrudRepository<Role, Serializable> {

    Role findRoleByCodeEquals(String code);

}
