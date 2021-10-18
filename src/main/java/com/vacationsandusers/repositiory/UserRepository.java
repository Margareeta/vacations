package com.vacationsandusers.repositiory;

import com.vacationsandusers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
