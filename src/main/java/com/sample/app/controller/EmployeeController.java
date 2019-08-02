package com.sample.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app.repository.EmployeeRepository;
import com.sample.app.model.*;

@RestController
@RequestMapping("api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository empRepo;

	@RequestMapping(value = "employees", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public List<Employee> all() {
		return empRepo.findAll();
	}

	@RequestMapping(value = "employees", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Employee> create(@RequestBody Employee emp) {
		Employee persistedEmp = empRepo.save(emp);

		return ResponseEntity.status(HttpStatus.CREATED).body(persistedEmp);
	}

	@RequestMapping(value = "employees", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('ADMIN')")
	public Employee update(@RequestBody Employee emp) {
		Employee persistedEmp = empRepo.save(emp);
		return persistedEmp;
	}

	@RequestMapping(value = "employees", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public HttpStatus delete(@PathVariable("id") Integer id) {
		empRepo.deleteById(id);

		return HttpStatus.OK;
	}

	@RequestMapping(value = "employees/{id}", method = RequestMethod.GET)
	public Employee byId(@PathVariable("id") Integer id) {
		return empRepo.findById(id).get();
	}
}
