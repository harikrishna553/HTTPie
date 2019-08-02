package com.sample.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app.model.Organization;

@RestController
public class HomeController {

	private static Organization org = new Organization();

	@GetMapping("/")
	public String sayHello() {
		return "Hello World";
	}

	@RequestMapping(value = "public/aboutUs", method = RequestMethod.POST)
	public ResponseEntity<Organization> create(@RequestBody Organization org) {
		HomeController.org = org;
		return ResponseEntity.status(HttpStatus.CREATED).body(org);
	}

	@RequestMapping(value = "public/aboutUs", method = RequestMethod.GET)
	public ResponseEntity<Organization> aboutUs() {
		return ResponseEntity.status(HttpStatus.OK).body(org);
	}

}
