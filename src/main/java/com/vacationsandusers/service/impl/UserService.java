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
//not sure we need this tested
      @Override
      public Page<User> list(Pageable pageable, String search) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.and(QUser.user.isDeleted.isFalse());
            if(search != null){
                  booleanBuilder.or(QUser.user.firstName.containsIgnoreCase(search));
                  booleanBuilder.or(QUser.user.lastName.containsIgnoreCase(search));
                  booleanBuilder.or(QUser.user.email.containsIgnoreCase(search));
            }
            return findAll(booleanBuilder, pageable);

      }
//tested does not work, hashcode problem
      @Override
      public User findById(Long id) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.and(QUser.user.isDeleted.isFalse());
            booleanBuilder.and(QUser.user.id.eq(id));
            return get(booleanBuilder).orElseThrow(RuntimeException::new);
      }
//tested, doesn't work. hashcode problem
      @Override
      public User create(User user) {
            return save(user);
      }
//tested, works
      @Override
      public User update(User user, Long id) {
            BooleanBuilder booleanBuilder = new BooleanBuilder();
            booleanBuilder.and(QUser.user.isDeleted.isFalse());
            booleanBuilder.and(QUser.user.id.eq(id));
            User foundUser = get(booleanBuilder).orElseThrow(RuntimeException::new);
            user.setCreatedAt(foundUser.getCreatedAt());
            user.setId(id);
            return save(user);
      }
//tested but does not work
      @Override
      public void deleteById(Long id) {
            User foundUser = repository.findByIdAndIsDeleted(id, false);
            foundUser.setDeleted(true);
      }
}
