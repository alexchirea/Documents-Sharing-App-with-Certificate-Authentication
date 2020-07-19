package com.alexchirea.ilvermory.repository;

import com.alexchirea.ilvermory.model.RoleUser;
import com.alexchirea.ilvermory.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface RoleUserRepository extends CrudRepository <RoleUser, Serializable> {
    List<RoleUser> findAllByUser(User user);
}
