package com.nshuti.Event_management_ticket_booking_system_backend_application.service;

import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImplementation implements BookingService{
    @Override
    public List<Booking> getAllBookings() {
        return null;
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        return null;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return null;
    }

    @Override
    public Booking updateBooking(Long bookingId, Booking booking) {
        return null;
    }

    @Override
    public void removeById(Long bookingId) {

    }
}
