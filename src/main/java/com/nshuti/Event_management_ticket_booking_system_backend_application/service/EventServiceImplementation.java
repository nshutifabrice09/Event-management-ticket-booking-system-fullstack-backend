package com.nshuti.Event_management_ticket_booking_system_backend_application.service;

import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImplementation implements EventService{
    @Override
    public List<Event> getAllEvents() {
        return null;
    }

    @Override
    public Event getEventById(Long eventId) {
        return null;
    }

    @Override
    public Event saveEvent(Event event) {
        return null;
    }

    @Override
    public Event updateEvent(Long eventId, Event event) {
        return null;
    }

    @Override
    public void removeById(Long eventId) {

    }
}
