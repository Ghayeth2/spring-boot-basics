package com.patika_course.controller;

import com.patika_course.bean.EmployeeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class EmployeeController {
    @Autowired private EmployeeBean employeeBean;

    // http://localhost:8080/api/employee
    @GetMapping("employee")
    @ResponseBody
    public ResponseEntity<String> getEmployeeDto(){
        return ResponseEntity.ok(employeeBean.getEmployeeBean()+"");
    }

    // Send bean to html file
    // http://localhost:8080/api/bean
    @GetMapping("/bean")
    public String employeeBean(Model model){
        model.addAttribute("employee", employeeBean.getEmployeeBean());
        return "index_0";
    }

    // Send Employee Beans to html file
    // http://localhost:8080/api/beans
    @GetMapping("/beans")
    public String employeeBeans(Model model){
        model.addAttribute("employees", employeeBean.getEmployeeBeans());
        return "index_0";
    }


}
