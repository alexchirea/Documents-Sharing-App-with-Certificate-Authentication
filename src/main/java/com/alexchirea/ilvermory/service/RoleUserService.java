package com.alexchirea.ilvermory.service;

import com.alexchirea.ilvermory.model.Role;
import com.alexchirea.ilvermory.model.RoleUser;
import com.alexchirea.ilvermory.model.User;
import com.alexchirea.ilvermory.repository.RoleUserRepository;
import com.alexchirea.ilvermory.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleUserService {

    private RoleUserRepository roleUserRepository;

    private UserRepository userRepository;

    @Autowired
    public RoleUserService(RoleUserRepository roleUserRepository, UserRepository userRepository) {
        this.roleUserRepository = roleUserRepository;
        this.userRepository = userRepository;
    }

    public List<Role> getRoles(User user) {
        List<RoleUser> roleUsers = roleUserRepository.findAllByUser(user);
        List<Role> result = new ArrayList<>();
        for(RoleUser roleUser : roleUsers) {
            result.add(roleUser.getRole());
        }
        return result;
    }

    public List<String> getRoleCodes(User user) {
        List<Role> roles = this.getRoles(user);
        List<String> result = new ArrayList<>();
        for(Role role : roles) {
            result.add(role.getCode());
        }
        return result;
    }

    public String getRoleCodeCommaSeparated(User user) {
        List<String> roles = this.getRoleCodes(user);
        return String.join(", ", roles);
    }

    public String getRoleCodeCommaSeparated(String username) {
        User user = userRepository.findUserByCommonNameEquals(username);
        List<String> roles = this.getRoleCodes(user);
        return String.join(", ", roles);
    }

    public RoleUser save(RoleUser roleUser) {
        return roleUserRepository.save(roleUser);
    }

}
