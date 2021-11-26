package com.vacationsandusers.service.impl;

import com.vacationsandusers.model.User;
import com.vacationsandusers.service.impl.Helper.TestDataProvider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PopulateWorkDbTest {
    @Autowired
    private UserService userService;
    @Autowired
    private TestDataProvider provider;


    @org.junit.jupiter.api.Test
    void addUsersWithVacationsTest(){

        for (int i = 1; i <= 25; i++) {
            User user = provider.buildUser1(i);
            userService.create(user);
        }
    }

    @org.junit.jupiter.api.Test
    void addUserNoVacationsTest(){
        for (int i = 26; i <= 50; i++) {
            User user = provider.buildUser2(i);
            userService.create(user);
        }
    }
    @Test
    void emptyTest(){}
}
