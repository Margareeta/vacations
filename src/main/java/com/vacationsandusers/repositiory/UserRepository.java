package com.vacationsandusers.repositiory;

import com.vacationsandusers.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long>{
    User findByIdAndIsDeleted(Long id, boolean isDeleted);
}
