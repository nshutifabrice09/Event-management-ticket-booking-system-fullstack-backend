package com.nshuti.Event_management_ticket_booking_system_backend_application.controller;

import com.nshuti.Event_management_ticket_booking_system_backend_application.exception.UserNotFoundException;
import com.nshuti.Event_management_ticket_booking_system_backend_application.model.User;
import com.nshuti.Event_management_ticket_booking_system_backend_application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/list/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/find/user/{userId}")
    User getUserById(@PathVariable Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException(userId));
    }

    @PutMapping("/edit/user/{userId}")
    User updateUser(@RequestBody User newUser, @PathVariable Long userId){
        return userRepository.findById(userId)
                .map(user -> {
                    user.setUserId(newUser.getUserId());
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setUserName(newUser.getUserName());
                    user.setPassword(newUser.getPassword());
                    user.setEmail(newUser.getEmail());
                    user.setPhoneNumber(newUser.getPhoneNumber());
                    user.setRole(newUser.getRole());
                    user.setBookings(newUser.getBookings());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(userId));
    }

    @DeleteMapping("/delete/users/{userId}")
    String deleteUser (@PathVariable Long userId){
        if(!userRepository.existsById(userId)){
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
        return "User with id "+userId+" has been deleted successfully";
    }

}
