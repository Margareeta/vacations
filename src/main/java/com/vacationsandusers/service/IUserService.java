package com.vacationsandusers.service;

import com.vacationsandusers.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface IUserService {
    Page<User> list(Pageable pageable, String search);

    User findById(Long id);

    User create(User user);

    User update(User user, Long id);

    void deleteById(Long id);
}

