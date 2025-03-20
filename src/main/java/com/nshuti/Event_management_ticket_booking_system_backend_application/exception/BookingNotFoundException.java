package com.nshuti.Event_management_ticket_booking_system_backend_application.exception;

public class BookingNotFoundException extends RuntimeException{

    public BookingNotFoundException(Long bookingId){
        super("Could not find the booking with id " +bookingId);
    }
}
