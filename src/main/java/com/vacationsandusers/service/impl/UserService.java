package com.vacationsandusers.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.vacationsandusers.model.QUser;
import com.vacationsandusers.model.User;
import com.vacationsandusers.repositiory.UserRepository;
import com.vacationsandusers.service.IUserService;
import com.vacationsandusers.service.base.AbstractBaseService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Data
@RequiredArgsConstructor//for finals
@Service
public class UserService extends AbstractBaseService <User, Long, UserRepository> implements IUserService {
      private final UserRepository repository;

      @Override
      public Page<User> list(Pageable pageable, String search) {
            return null;
      }

      @Override
      public User findById(Long id) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.and(QUser.user.isDeleted.isFalse());
            booleanBuilder.and(QUser.user.id.eq(id));
            return get(booleanBuilder).orElseThrow(RuntimeException::new);
      }

      @Override
      public User create(User user) {
            repository.save(user);
            return save(user);
      }

      @Override
      public User update(User user, Long id) {
            return null;
      }

      @Override
      public void deleteById(Long id) {

      }
}
