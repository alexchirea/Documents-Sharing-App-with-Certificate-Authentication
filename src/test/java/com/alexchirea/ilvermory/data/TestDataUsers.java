package com.alexchirea.ilvermory.data;

import com.alexchirea.ilvermory.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataUsers {

    private List<User> users;

    public static final List<String> aCommonNames = Arrays.asList("WERB0000", "WERB0001", "WERB0002", "WERB0003", "WERB0004");
    public static final List<String> aFirstNames = Arrays.asList("John", "Andrew", "Mike", "George", "Alex");
    public static final List<String> aLastNames = Arrays.asList("Smith", "McDonalds", "Smith", "Washer", "Weasley");
    
    public TestDataUsers() {
        users = new ArrayList<User>();
        for(int i = 0; i < aCommonNames.size(); i++) {
            users.add(new User(aCommonNames.get(i), aFirstNames.get(i), aLastNames.get(i)));
        }
    }

    public List<User> getUsers() {
        return users;
    }

}
