package com.patika_course.api.controller;

import com.patika_course.business.abstracts.UserService;
import com.patika_course.model.dtos.UserDto;
import com.patika_course.tutorials.dtos.PlayerDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller @Log4j2
@RequestMapping("/registration")
public class UserController {
    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public UserDto userDtoObj(){
        return new UserDto();
    }

    @GetMapping
    public String registerForm(){
        return "registerForm";
    }

    @PostMapping
    public String saveUser(@Valid @ModelAttribute("user")UserDto userDto,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDto);
            log.error("An error occurred!");
            return "registerForm";
        }
        log.info("Success " + userDto);
        userService.save(userDto);
        return "redirect:/registration?success";
    }
}
