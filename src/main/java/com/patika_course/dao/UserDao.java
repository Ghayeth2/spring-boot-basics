package com.patika_course.dao;

import com.patika_course.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
