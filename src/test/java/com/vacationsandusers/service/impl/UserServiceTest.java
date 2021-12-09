package com.vacationsandusers.service.impl;

import com.vacationsandusers.model.User;
import com.vacationsandusers.model.Vacation;
import com.vacationsandusers.service.impl.Helper.TestDataProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private TestDataProvider provider;
    private Long id1;

    @AfterEach
    void deleteTestData() {
        userService.deleteAll();
    }

    @Test
    void userListTest() {
        User user1 = provider.buildUser1(1);
        User user2 = provider.buildUser2(2);
        userService.create(user1);
        userService.create(user2);
        Assertions.assertEquals(2, userService.list().size());
    }

    @Test
    void createAndFindByIdUserTest() {
        User user = provider.buildUser1(1);
        id1 = userService.create(user).getId();
        User byId = userService.findById(id1);
        user.setId(id1);
        for (int i = 0; i < user.getUsersVacations().size(); i++) {
            Vacation expected = user.getUsersVacations().get(i);
            Vacation actual = byId.getUsersVacations().get(i);
            Assertions.assertEquals(expected.getDateFrom(), actual.getDateFrom());
            Assertions.assertEquals(expected.getDateTo(), actual.getDateTo());
        }
        Assertions.assertEquals(user.getFirstName(), byId.getFirstName());
        Assertions.assertEquals(user.getLastName(), byId.getLastName());
        Assertions.assertEquals(user.getEmail(), byId.getEmail());

    }

    @Test
    void updateUserTest() {
        User user = provider.buildUser1(1);
        id1 = userService.create(user).getId();
        User updated = userService.update(user, id1);
        for (int i = 0; i < user.getUsersVacations().size(); i++) {
            Vacation expected = user.getUsersVacations().get(i);
            Vacation actual = updated.getUsersVacations().get(i);
            Assertions.assertEquals(expected.getDateFrom(), actual.getDateFrom());
            Assertions.assertEquals(expected.getDateTo(), actual.getDateTo());
        }

        Assertions.assertEquals(user.getFirstName(), updated.getFirstName());
        Assertions.assertEquals(user.getLastName(), updated.getLastName());
        Assertions.assertEquals(user.getEmail(), updated.getEmail());
    }

    @Test
    void deleteUserTest() {

        User user = provider.buildUser1(1);
        id1 = userService.create(user).getId();
        int size = userService.list().size();
        userService.deleteById(id1);
        int reducedSize = userService.list().size();
        Assertions.assertEquals(size - 1, reducedSize);
    }

    @Test
    void deleteAllUsersTest() {
        User user = provider.buildUser1(1);
        User user1 = provider.buildUser2(2);
        userService.create(user);
        userService.create(user1);
        userService.deleteAll();
        int size = userService.list().size();
        Assertions.assertEquals(0, size);
    }


}