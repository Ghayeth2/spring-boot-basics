package com.patika_course.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data @Log4j2 @Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private int id;
    @NotEmpty(message = "Full name is requried!")
    private String fullName;
    @NotEmpty(message = "Required field!")
    @Size(min = 8, max = 24, message = "Password should be in between 8 & 24 digits!")
    private String password;
    @Email(message = "Please, enter email formatted text")
    @NotEmpty(message = "Email cannot be empty!")
    private String email;

}
