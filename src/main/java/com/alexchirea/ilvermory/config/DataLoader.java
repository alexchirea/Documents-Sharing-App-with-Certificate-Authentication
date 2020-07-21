package com.alexchirea.ilvermory.config;

import com.alexchirea.ilvermory.model.Document;
import com.alexchirea.ilvermory.model.Role;
import com.alexchirea.ilvermory.model.RoleUser;
import com.alexchirea.ilvermory.model.User;
import com.alexchirea.ilvermory.model.enums.DocumentClassification;
import com.alexchirea.ilvermory.service.DocumentService;
import com.alexchirea.ilvermory.service.RoleService;
import com.alexchirea.ilvermory.service.RoleUserService;
import com.alexchirea.ilvermory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements ApplicationRunner {

    private UserService userService;
    private RoleService roleService;
    private RoleUserService roleUserService;
    private DocumentService documentService;

    @Autowired
    public DataLoader(UserService userService, RoleService roleService, RoleUserService roleUserService,
                      DocumentService documentService) {
        this.userService = userService;
        this.roleService = roleService;
        this.roleUserService = roleUserService;
        this.documentService = documentService;
    }

    public void run(ApplicationArguments args) {
        Role oRoleUser = roleService.save(new Role("ROLE_USER"));
        Role oRoleAdmn = roleService.save(new Role("ROLE_ADMIN"));
        User oUser = userService.save(new User("WERB3011", "Alex", "C"));
        roleUserService.save(new RoleUser(oUser, oRoleUser));
        roleUserService.save(new RoleUser(oUser, oRoleAdmn));

        Document document1 = new Document("Test Document", "test_doc.txt");
        document1.setUser(oUser);
        document1.setClassification(DocumentClassification.CONFIDENTIAL);
        documentService.save(document1);

        Document document2 = new Document("Secure Document", "secure_doc.txt");
        document2.setUser(oUser);
        document2.setClassification(DocumentClassification.RESTRICTED);
        documentService.save(document2);
    }
}
