package com.vacationsandusers.repositiory;

import com.vacationsandusers.model.QUser;
import com.vacationsandusers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long>{
}
