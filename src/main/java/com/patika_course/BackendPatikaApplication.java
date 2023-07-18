package com.patika_course;

import com.patika_course.model.dtos.Roles;
import com.patika_course.model.entities.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Security inactive
//@SpringBootApplication(exclude = {
//        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
//        org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class}
//)
// Enabling JpaAuditing
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@SpringBootApplication
public class  BackendPatikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPatikaApplication.class, args);

	}


}
