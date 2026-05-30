package com.Reservation.bus.Repo;

import org.springframework.data.jpa.repository.JpaRepository;  // ✅ ADD THIS
import java.util.Optional;

import com.Reservation.bus.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {  // ✅ FIX

    Optional<User> findByUsername(String username);
    
}