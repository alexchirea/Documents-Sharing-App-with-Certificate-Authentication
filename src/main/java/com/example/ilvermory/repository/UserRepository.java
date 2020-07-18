package com.example.ilvermory.repository;

import com.example.ilvermory.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByCommonNameEquals(String commonName);
    User save(User user);
}
