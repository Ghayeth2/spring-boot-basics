package com.patika_course.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotNull(message = "This field is required!")
    private String firstName;
    @NotNull(message = "This field is required!")
    private String lastName;
    @Email(message = "Enter email formatted text!")
    @NotNull(message = "This field is required!")
    private String email;
    @NotNull(message = "This field is required!")
    @Size(min = 6, max = 40, message = "Password at least 6 characters, at most 40!")
    private String password;
}
