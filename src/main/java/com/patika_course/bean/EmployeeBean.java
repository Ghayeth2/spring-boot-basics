package com.patika_course.bean;

import com.patika_course.dtos.EmployeeDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
// This annotation along with Bean is to make the class and mehtods
// in it identifiable by Spring in normal case (No Spring Boot)
public class EmployeeBean {
    @Bean(initMethod = "initBeanMethod", destroyMethod = "destroyBeanMethod")
    @Scope("singleton")// request session
    // to make the Java function code as Bean so Spring could identify bean
    // this is what should the case be without using Spring Boot, now we don't
    // use this anymore bcz we have Spring Boot does this in background for us.
    public EmployeeDto getEmployeeBean(){
        return EmployeeDto.builder()
                    .studentNo(1910206548L)
                    .firstName("GHAYETH")
                    .lastName("AL MASRI")
                    .department("Computer Engineering")
                .build();
    }
}
