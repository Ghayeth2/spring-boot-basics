package com.patika_course.business.concretes;

import com.patika_course.business.abstracts.UserService;
import com.patika_course.core.bean.PasswordEncoderBean;
import com.patika_course.core.model.User;
import com.patika_course.core.utils.converter.DtoEntityConverter;
import com.patika_course.dao.UserDao;
import com.patika_course.model.dtos.UserDto;
import com.patika_course.model.entities.Role;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class UserManager implements UserService {

    private UserDao userDao;

    private DtoEntityConverter converter;

    private PasswordEncoderBean passwordEncoder;

    @Autowired
    public UserManager(UserDao userDao, DtoEntityConverter converter, PasswordEncoderBean passwordEncoder) {
        this.userDao = userDao;
        this.converter = converter;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(UserDto userDto) {
        User user = (User) converter.dtoToEntity(userDto, new User());
        // Encrypting password
        user.setPassword(passwordEncoder.passwordEncoder().encode(user.getPassword()));
        user.setRoles(Arrays.asList(new Role("User")));
        userDao.save(user);
    }

    // Security services
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password!");
        }
        log.info(user.getEmail());
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles())
        );
    }

    // Mapping Roles GrantedAuthority
    private List<? extends GrantedAuthority> mapRolesToAuthorities(List<Role> roles){
        return roles.stream().map(
                // Changing Roles to SimpleGrantedAuthority Object
                role ->  new SimpleGrantedAuthority(role.getName())
        ).collect(Collectors.toList());
    }
}
