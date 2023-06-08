package com.patika_course.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data @NoArgsConstructor
@AllArgsConstructor
@Log4j2 @Builder
public class EmployeeDto {
    private Long studentNo;
    private String firstName;
    private String lastName;
    private String department;

    public void initBeanMethod(){
        log.info("Instantiating bean is done after this mehthod");
        System.out.println("Your bean will bean initiated soon");
    }

    public void destroyBeanMethod(){
        log.info("Killing the bean is done after this method");
        System.err.println("Your bean will be killed soon");
    }
}
