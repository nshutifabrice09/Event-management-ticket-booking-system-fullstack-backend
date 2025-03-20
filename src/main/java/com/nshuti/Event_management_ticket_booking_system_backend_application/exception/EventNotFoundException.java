package com.nshuti.Event_management_ticket_booking_system_backend_application.exception;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(Long eventId){
        super("Could not find the event with id" +eventId);
    }
}
