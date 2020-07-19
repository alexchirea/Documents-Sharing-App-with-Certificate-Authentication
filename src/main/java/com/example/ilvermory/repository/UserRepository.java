package com.example.ilvermory.repository;

import com.example.ilvermory.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends CrudRepository<User, Serializable> {
    User findUserByCommonNameEquals(String commonName);
}
