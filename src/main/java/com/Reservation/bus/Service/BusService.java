package com.Reservation.bus.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Reservation.bus.Entity.Bus;
import com.Reservation.bus.Repo.BusRepository;
@Service
public class BusService {

	@Autowired
	BusRepository repository;
	public Page<Bus> getAllBuses(Pageable pageable) {
	    return repository.findAll(pageable);
}}
