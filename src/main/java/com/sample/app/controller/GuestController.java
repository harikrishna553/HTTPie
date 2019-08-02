package com.sample.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.app.model.Guest;
import com.sample.app.repository.GuestRepository;

@RestController
@RequestMapping("public/v1/")
public class GuestController {
	@Autowired
	private GuestRepository guestRepository;

	@RequestMapping(value = "guests", method = RequestMethod.GET)
	public List<Guest> all(@Param(value = "firstName") String firstName) {
		
		if(firstName != null) {
			return guestRepository.findByFirstName(firstName);
		}
		
		return guestRepository.findAll();
	}

	@RequestMapping(value = "guests", method = RequestMethod.POST)
	public ResponseEntity<Guest> create(@RequestBody Guest guest) {
		Guest persistedGuest = guestRepository.save(guest);
		return ResponseEntity.status(HttpStatus.CREATED).body(persistedGuest);
	}

	@RequestMapping(value = "guests", method = RequestMethod.PUT)
	public Guest update(@RequestBody Guest guest) {
		Guest persistedGuest = guestRepository.save(guest);
		return persistedGuest;
	}

	@RequestMapping(value = "guests/{id}", method = RequestMethod.DELETE)
	public HttpStatus delete(@PathVariable("id") Integer id) {
		guestRepository.deleteById(id);
		return HttpStatus.OK;
	}
	
	@RequestMapping(value = "guests/{id}", method = RequestMethod.GET)
	public Guest byId(@PathVariable("id") Integer id) {
		return guestRepository.findById(id).get();
	}
}
