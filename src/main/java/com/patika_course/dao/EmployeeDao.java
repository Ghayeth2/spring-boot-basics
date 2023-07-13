package com.patika_course.dao;

import com.patika_course.model.dtos.EmployeeDto;
import com.patika_course.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
