package com.vacationsandusers.service.impl;

import com.vacationsandusers.model.User;
import com.vacationsandusers.repositiory.UserRepository;
import com.vacationsandusers.service.base.AbstractBaseService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Data
@RequiredArgsConstructor//for finals
@Service
public class UserService extends AbstractBaseService <User, Long, UserRepository> {
      private final UserRepository repository;


}
