package com.Reservation.bus.Repo;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Reservation.bus.Entity.Bus;
import com.Reservation.bus.Entity.User;

	public interface BusRepository extends JpaRepository<Bus, Long> {
		Page<Bus> findAll(Pageable pageable);

	}

