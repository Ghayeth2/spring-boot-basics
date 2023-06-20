package com.patika_course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // http://localhost:8080/thymeleaf1/index0
    // what if user entered different format for index page
    @GetMapping({"/index0",  ""})
    public String index_0(){
        return "index_0";
    }

    // http://localhost:8080/thymeleaf1/index_0Data
    @GetMapping("/index_0Data")
    public String index_0Data(Model model){
        model.addAttribute("static_data","This is static data sent to template");
        return "index_0";
    }

    // http://localhost:8080/thymeleaf1/index/8
    /*
    if u want it to crash and give 500 server error when there's no id
    then put id field as required or leave it as default
    otherwise, u can assign required to false in case u want to send costume message
     */
    @GetMapping({"/index/{id}", "/index"})
    public String index(@PathVariable(value = "id", required = false) Integer id, Model model){
        if(id != null)
            model.addAttribute("id", "Coming id: "+id);
        else
            model.addAttribute("id", "No id found");
        return "index_0";
    }

}
