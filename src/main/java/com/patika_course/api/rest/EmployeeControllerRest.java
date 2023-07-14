package com.patika_course.api.rest;

import com.patika_course.business.abstracts.EmployeeServices;
import com.patika_course.model.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeControllerRest {
    @Autowired
    private EmployeeServices employeeServices;

    // https://localhost:8080/api/v1/new
    @PostMapping("/new")
    /*
      Validation Error not handled in Back-end side

        Using @ExceptionHandler & @RestControllerAdvice is handy for back-end
     */
    public ResponseEntity<String> save(@Valid @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(this.employeeServices.save(employeeDto), HttpStatus.CREATED);
    }

    //https://loaclhost:8080/api/v1/employees
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> allEmployees(){
        return new ResponseEntity<>(this.employeeServices.listAll(), HttpStatus.OK);
    }

    //https://localhost:8080/api/v1/1
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.employeeServices.getById(id), HttpStatus.OK);
    }

    //https://localhost:8080/api/v1/update/1
    @PutMapping("/update/{id}")
    /*
      Validation Error not handled in Back-end side

       Using @ExceptionHandler & @RestControllerAdvice is handy for back-end
     */
    public ResponseEntity<String> update(@Valid @RequestBody EmployeeDto employeeDto, @PathVariable("id") Long id){
        return new ResponseEntity<>(this.employeeServices.update(employeeDto, id), HttpStatus.ACCEPTED);
    }

    //https://localhost:8080/api/v1/delete/1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.employeeServices.delete(id));
    }
}
