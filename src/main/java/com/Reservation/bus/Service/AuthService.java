package com.Reservation.bus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Reservation.bus.Entity.User;
import com.Reservation.bus.Repo.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    public String login(User user) {

        User existing = repo.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!existing.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        // 🔥 Temporary token (next step we replace with JWT)
        return "LOGIN_SUCCESS_TOKEN";
    }
}