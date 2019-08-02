package com.sample.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.app.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
	public List<Guest> findByFirstName(String firstName);
}
