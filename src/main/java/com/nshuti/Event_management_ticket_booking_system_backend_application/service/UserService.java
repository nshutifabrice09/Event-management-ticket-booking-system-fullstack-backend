package com.nshuti.Event_management_ticket_booking_system_backend_application.service;

import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Payment;
import com.nshuti.Event_management_ticket_booking_system_backend_application.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    User saveUser(User user);
    User updateUser(Long userId, User user);
    void removeById(Long userId);
}
