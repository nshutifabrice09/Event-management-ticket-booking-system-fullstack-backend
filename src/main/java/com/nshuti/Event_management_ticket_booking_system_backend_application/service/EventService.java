package com.nshuti.Event_management_ticket_booking_system_backend_application.service;
import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();
    Event getEventById(Long eventId);
    Event saveEvent(Event event);
    Event updateEvent(Long eventId, Event event);
    void removeById(Long eventId);
}
