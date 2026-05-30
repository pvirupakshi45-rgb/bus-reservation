package com.Reservation.bus.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Reservation.bus.Entity.User;
import com.Reservation.bus.Repo.UserRepository;
import com.Reservation.bus.Security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return userRepository.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());

        Optional<User> existingUser =
                userRepository.findByUsername(
                        user.getUsername());

        System.out.println(existingUser);

        if(existingUser.isPresent()) {

            System.out.println(
                    existingUser.get().getPassword());

            if(existingUser.get().getPassword()
                    .equals(user.getPassword())) {

                JwtUtil jwtUtil = new JwtUtil();

                String token =
                        jwtUtil.generateToken(
                                user.getUsername());

                System.out.println(token);

                return token;
            }
        }

        return "Invalid Credentials";
    }
}