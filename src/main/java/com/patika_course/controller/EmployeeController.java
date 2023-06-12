package com.patika_course.controller;

import com.patika_course.bean.EmployeeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
}
