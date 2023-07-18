package com.patika_course.business.abstracts;

import com.patika_course.model.dtos.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void save(UserDto userDto);
}
