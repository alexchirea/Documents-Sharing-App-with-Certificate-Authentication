package com.alexchirea.ilvermory.service;

import com.alexchirea.ilvermory.model.Role;
import com.alexchirea.ilvermory.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByCode(String code) {
        return roleRepository.findRoleByCodeEquals(code);
    }

    public Role save(Role r) {
        return roleRepository.save(r);
    }

    public List<Role> save(List<Role> r) {
        return (List<Role>) roleRepository.saveAll(r);
    }

}
