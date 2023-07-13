package com.patika_course.business.abstracts;

import com.patika_course.model.dtos.EmployeeDto;
import com.patika_course.model.entities.Employee;

import java.util.List;

public interface EmployeeServices {
    String save(EmployeeDto employeeDto);
    List<EmployeeDto> listAll();
    String update(EmployeeDto employeeDto, Long id);
    String delete(Long id);
    EmployeeDto getById(Long id);
    // Search in Ajax or ActionListener
}
