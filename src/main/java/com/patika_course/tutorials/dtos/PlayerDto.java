package com.patika_course.tutorials.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data @Log4j2 @Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "player")
public class PlayerDto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Full name is requried!")
    @Column(name = "full_name",length = 40, nullable = false)
    private String fullName;
    @NotEmpty(message = "Required field!")
    @Size(min = 8, max = 24, message = "Password should be in between 8 & 24 digits!")
    @Column(name = "password", length = 24, nullable = false)
    private String password;
    @Email(message = "Please, enter email formatted text")
    @NotEmpty(message = "Email cannot be empty!")
    @Column(name = "email", length = 50, nullable = false)
    private String email;

}
