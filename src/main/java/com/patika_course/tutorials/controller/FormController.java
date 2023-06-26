package com.patika_course.tutorials.controller;

import com.patika_course.tutorials.dtos.PlayerDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller @Log4j2
@RequestMapping("/form")
public class FormController {
    // http://localhost:8080/form
    @GetMapping("")
    public String form(Model model){
        model.addAttribute("player", new PlayerDto());
        return "formValidation";
    }

    // http://localhost:8080/form
    // Can I use same below code only without sending Empty Object for Save operation too??
    @PostMapping("")
    public String form(@Valid @ModelAttribute("player") PlayerDto player,
                       BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("player", player);
            log.error("An error occurred!");
            return "formValidation";
        }
        log.info("Success "+player);
        // Database saving  (SRP) >> Saving to database should not be in controller
        // File saving      (SRP) >> Saving to file should not be in controller
        return "success";

    }
}
