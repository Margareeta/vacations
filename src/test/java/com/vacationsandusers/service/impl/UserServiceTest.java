package com.vacationsandusers.service.impl;

import com.vacationsandusers.BaseIntegrationTest;
import com.vacationsandusers.model.User;
import com.vacationsandusers.service.IUserService;
import com.vacationsandusers.service.impl.Helper.TestDataProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class UserServiceTest extends BaseIntegrationTest {

    private final IUserService service;
    private final TestDataProvider provider;

    @Autowired
    public UserServiceTest(IUserService service, TestDataProvider provider) {
        this.service = service;
        this.provider = provider;
    }
//creates and searches different users. why?
    @Test
    void shouldCreateAndFindById(){
        User createdUser = service.create(provider.buildFullUser(1));
        User foundUser = service.findById(createdUser.getId());


        Assertions.assertEquals(createdUser, foundUser);
    }
    //doesn't delete the user I create. Why?
    @Test
    void shouldDeleteUserById(){
        User createdUser = service.create(provider.buildFullUser(2));
        service.deleteById(createdUser.getId());

        Assertions.assertEquals(true, createdUser.isDeleted());
    }
    @Test
    void shouldUpdateUserById(){
        User createdUser = service.create(provider.buildFullUser(3));
        createdUser.setFirstName("Jane");
        createdUser.setLastName("Doe");
        User updatedUser = service.update(createdUser, createdUser.getId());

        Assertions.assertEquals("Jane", updatedUser.getFirstName());
        Assertions.assertEquals("Doe", updatedUser.getLastName());

    }


}