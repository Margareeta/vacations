package com.vacationsandusers.service.impl;

import com.vacationsandusers.model.User;
import com.vacationsandusers.repositiory.UserRepository;
import com.vacationsandusers.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Override
    public List<User> list() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user, Long id) {
        user.setId(id);
        return repository.save(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public void deleteAll() {
        repository.deleteAll();

    }
}
