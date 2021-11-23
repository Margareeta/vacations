package com.vacationsandusers.service;

import com.vacationsandusers.model.User;

import java.util.List;

public interface IUserService {
    List<User> list();
    User findById(Long id);
    User create(User user);
    User update (User user, Long id);
    void  delete(Long id);
    void deleteAll();
}
