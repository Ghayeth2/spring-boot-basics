package com.patika_course.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    @NotEmpty(message = "This field is required!")
    private String firstName;
    @NotEmpty(message = "This field is required!")
    private String lastName;
    @NotEmpty(message = "This field is required!")
    @Size(min = 8, max = 20, message = "Password is within 8 to 20 ")
    private String password;
    @Email(message = "Email format is required!")
    @NotEmpty(message = "This field is required!")
    private String email;
}
