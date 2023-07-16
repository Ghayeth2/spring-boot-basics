package com.patika_course;

import com.patika_course.dao.EmployeeDao;
import com.patika_course.model.entities.Employee;
import com.patika_course.test.TestServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BackendPatikaApplicationTests implements TestServices {

	// with tests we connect to DAO directly without Business layer
	// To run test we need to reset database by dropping the table.
	// or write more dynamic test codes
	@Autowired private EmployeeDao employeeDao;

	@Test // Create a record
	@Override
	public void create() {
		// Fill entity data
		Employee employee = Employee.builder()
				.firstName("GHAEYTH")
				.lastName("AL MASRI")
				.email("amal@gmail.com")
				.password("789456")
				.build();
		// save to database
		employeeDao.save(employee);
		// run test result for what should be returned or not
		// in this case, should not return null data
		// 1L > is considered that our test record is first in database
		assertNotNull(employeeDao.findById(1L).get());
	}

	@Test // Get all records
	@Override
	public void listAll() {
		// get all records
		List<Employee> employees = employeeDao.findAll();
		// if size == 0 then no records returned. Problem occurred
		assertThat(employees).size().isGreaterThan(0);
	}

	@Test // Update a record
	@Override
	public void update() {
		// Fetch current record
		Employee employee = employeeDao.findById(1L).get();
		// Making changes in record
		employee.setFirstName("JAMAL");
		// save updated data
		employeeDao.save(employee);
		// Making sure update worked just fine
		/* If the first name returned out of database is equal to JAMAL
		   update has worked. If not > Error
		 */
		assertEquals("JAMAL", employeeDao.findById(1L).get().getFirstName());
	}

	@Test // Get a record by id
	@Override
	public void getById() {

	}
	@Test // Delete a record
	@Override
	public void delete() {
		// deleting the record
		employeeDao.deleteById(1L);
		// Is the record has been deleted?
		/*
			If record was deleted, it won't exist
		 */
		assertThat(employeeDao.existsById(1L)).isFalse();
	}
}
