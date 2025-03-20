package com.nshuti.Event_management_ticket_booking_system_backend_application.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId){
        super("Could not find the route with id "+ userId );
    }
}

