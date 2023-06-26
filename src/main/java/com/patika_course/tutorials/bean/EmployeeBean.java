package com.patika_course.tutorials.bean;

import com.patika_course.tutorials.dtos.EmployeeDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Bean
    @Scope("request")
    public List<EmployeeDto> getEmployeeBeans(){
        List<EmployeeDto> employees = new ArrayList<>(Arrays.asList(
                EmployeeDto.builder().firstName("GHAYETH").lastName("AL MASRI").department("CMPE").studentNo(1910206548L).build(),
                EmployeeDto.builder().firstName("YASIN").lastName("AL SAYASNEH").department("YZM").studentNo(1910206549L).build(),
                EmployeeDto.builder().firstName("AHMAD").lastName("OZDEMIR").department("TIP").studentNo(1910206550L).build(),
                EmployeeDto.builder().firstName("MOHAMMAD").lastName("MAHAMEED").department("ECZ").studentNo(1910206551L).build()
        ));
        return employees;
    }
}
