package com.nshuti.Event_management_ticket_booking_system_backend_application.repository;

import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {

}
