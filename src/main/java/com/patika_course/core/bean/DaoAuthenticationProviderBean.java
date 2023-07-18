package com.patika_course.core.bean;

import com.patika_course.business.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

@Configuration
public class DaoAuthenticationProviderBean {

    @Autowired private PasswordEncoderBean passwordEncoder;

    @Autowired private UserService userService;
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder.passwordEncoder());
        return auth;
    }
}
