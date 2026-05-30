package com.Reservation.bus.Controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Reservation.bus.Entity.Bus;
import com.Reservation.bus.Exception.BusException;
import com.Reservation.bus.Repo.BusRepository;
import com.Reservation.bus.Service.BusService;
@RestController
@RequestMapping("/bus")
public class BusController {
	@Autowired
    private BusRepository repo;
	

	@Autowired
	BusService busservice ;
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
    @GetMapping("/{id}")
    public Bus getbyid(@PathVariable Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new BusException("Bus not found with id: " + id));
    }

    
    
    @DeleteMapping("/{id}")
    public String deleteBus(@PathVariable Long id) {

        Bus bus = repo.findById(id)
                .orElseThrow(() -> new BusException("Bus not found with id: " + id));

        repo.delete(bus);
        return "Bus Deleted Successfully";
    }
    
    @GetMapping("/buses")
    public Page<Bus> getAllBuses(Pageable pageable) {
        return busservice.getAllBuses(pageable);
    }
    
//    @PostMapping
//    public Bus addBus1( @RequestBody Bus bus) {
//    	System.out.println("created");
//        return repo.save(bus);
    }




