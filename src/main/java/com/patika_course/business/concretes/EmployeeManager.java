package com.patika_course.business.concretes;

import com.patika_course.business.abstracts.EmployeeServices;
import com.patika_course.core.exception.ResourceNotFoundException;
import com.patika_course.core.utils.converter.DtoEntityConverter;
import com.patika_course.dao.EmployeeDao;
import com.patika_course.model.dtos.EmployeeDto;
import com.patika_course.model.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeManager implements EmployeeServices {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DtoEntityConverter converter;
    @Override
    public String save(EmployeeDto employeeDto) {
        Employee employee = (Employee) converter.dtoToEntity(employeeDto, new Employee());
        employeeDao.save(employee);
        return "Employee saved successfully";
    }

    @Override
    public List<EmployeeDto> listAll() {
        List<EmployeeDto> employeeDtos = (List<EmployeeDto>)(List<?>) converter.entitiesToDtos(
                 employeeDao.findAll(), new EmployeeDto()
        );
        return employeeDtos;
    }

    @Override
    public String update(EmployeeDto employeeDto, Long id) {
        // it might not be present in database > Optional?
        if(employeeDao.existsById(id)){
            Employee employee = (Employee) converter.dtoToEntity(employeeDto, new Employee());
            Employee oldEmployee = this.employeeDao.getById(id);

            oldEmployee.setFirstName(employee.getFirstName());
            oldEmployee.setLastName(employee.getLastName());
            oldEmployee.setEmail(employee.getEmail());
            oldEmployee.setPassword(employee.getPassword());

            this.employeeDao.save(oldEmployee);
            return "Employee updated successfully";
        }
        return ""+new ResourceNotFoundException("No employee found for given id: "+id);
    }

    @Override
    public String delete(Long id) {
        if(this.employeeDao.existsById(id)){
            this.employeeDao.deleteById(id);
            return "Employee deleted successfully";
        }
        return ""+new ResourceNotFoundException("No employee found for given id: "+id);
    }

    @Override
    public EmployeeDto getById(Long id) {
        EmployeeDto employeeDto = (EmployeeDto) converter.entityToDto
                (this.employeeDao.findById(id).orElse(null),
                new EmployeeDto());
        return employeeDto;
    }
}
