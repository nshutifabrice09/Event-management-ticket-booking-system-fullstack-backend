package com.nshuti.Event_management_ticket_booking_system_backend_application.repository;

import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BookingRepository extends JpaRepository <Booking, Long> {

}
