package com.nshuti.Event_management_ticket_booking_system_backend_application.controller;

import com.nshuti.Event_management_ticket_booking_system_backend_application.model.User;
import com.nshuti.Event_management_ticket_booking_system_backend_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/Users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser   (@RequestBody User newUser){
        return userRepository.save(newUser);
    }
}
