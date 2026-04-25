package com.Reservation.bus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Reservation.bus.Entity.Bus;
import com.Reservation.bus.Repo.BusRepository;
@RestController
@RequestMapping("/bus")
public class BusController {
	@Autowired
    private BusRepository repo;

    // Add Bus
    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        return repo.save(bus);
    }
    // Get All Buses
    @GetMapping
    public List<Bus> getAll() {
        return repo.findAll();
    }
}
