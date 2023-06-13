package com.patika_course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf1")
public class ThymeLeafController {
    // 500 server error
    /*
    if the url is wrong (Not registered in api urls)
    404 not found error page will show

    if the url exists however, the page contains nothing
    500 server side error will be returned

    // http://localhost:8080/thymeleaf/s_err // Unregistered URL
    // http://localhost:8080/thymeleaf1/s_err // Registered URL
     */

    @GetMapping("/s_err")
    public String servError(){
        return null;
    }

    // http://localhost:8080/thymeleaf1/index_0
    @GetMapping("/index_0")
    public String index_0(){
        return "index_0";
    }

    // http://localhost:8080/thymeleaf1/index_0Data
    @GetMapping("/index_0Data")
    public String index_0Data(Model model){
        model.addAttribute("static_data","This is static data sent to template");
        return "index_0";
    }

}
