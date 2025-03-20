package com.nshuti.Event_management_ticket_booking_system_backend_application.controller;

import com.nshuti.Event_management_ticket_booking_system_backend_application.exception.BookingNotFoundException;
import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Booking;
import com.nshuti.Event_management_ticket_booking_system_backend_application.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/register/booking")
    Booking newBooking(@RequestBody Booking newBooking){
        return bookingRepository.save(newBooking);
    }

    @GetMapping("/list/bookings")
    List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    @GetMapping("/find/booking/{bookingId}")
    Booking getBookingById(@PathVariable Long bookingId){
        return bookingRepository.findById(bookingId)
                .orElseThrow(()->new BookingNotFoundException(bookingId));
    }

    @PutMapping("/edit/booking/{bookingId}")
    Booking updateBooking (@RequestBody Booking newBooking, @PathVariable Long bookingId){
        return bookingRepository.findById(bookingId)
                .map(booking -> {
                    booking.setBookingId(newBooking.getBookingId());
                    booking.setUser(newBooking.getUser());
                    booking.setEvent(newBooking.getEvent());
                    booking.setStatus((newBooking.getStatus()));
                    return bookingRepository.save(booking);
                }).orElseThrow(()->new BookingNotFoundException(bookingId));
    }


    @DeleteMapping("/delete/booking/{bookingId}")
    String deleteBooking (@PathVariable Long bookingId){
        if(!bookingRepository.existsById(bookingId)){
            throw new BookingNotFoundException(bookingId);
        }
        bookingRepository.deleteById(bookingId);
        return "Booking with id "+bookingId+" has been deleted successfully.";
    }
}
