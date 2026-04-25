package com.Reservation.bus.Repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Reservation.bus.Entity.Bus;

	public interface BusRepository extends JpaRepository<Bus, Long> {
	}

