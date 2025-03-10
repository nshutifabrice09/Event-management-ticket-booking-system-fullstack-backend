package com.nshuti.Event_management_ticket_booking_system_backend_application.service;

import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Booking;
import java.util.List;


public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(Long bookingId);
    Booking saveBooking(Booking booking);
    Booking updateBooking(Long bookingId, Booking booking);
    void removeById(Long bookingId);

}
