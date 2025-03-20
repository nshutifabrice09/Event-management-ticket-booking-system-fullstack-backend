package com.nshuti.Event_management_ticket_booking_system_backend_application.controller;

import com.nshuti.Event_management_ticket_booking_system_backend_application.exception.BookingNotFoundException;
import com.nshuti.Event_management_ticket_booking_system_backend_application.exception.EventNotFoundException;
import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Booking;
import com.nshuti.Event_management_ticket_booking_system_backend_application.model.Event;
import com.nshuti.Event_management_ticket_booking_system_backend_application.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EventController {

    @Autowired
    public EventRepository eventRepository;

    @PostMapping("/register/event")
    Event newEvent (@RequestBody Event newEvent){
        return eventRepository.save(newEvent);
    }

    @GetMapping("/list/events")
    List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    @GetMapping("/find/event/{eventId}")
    Event getEventById(@PathVariable Long eventId){
        return eventRepository.findById(eventId)
                .orElseThrow(()->new EventNotFoundException(eventId));
    }
    @PutMapping("/edit/event/{eventId}")
    Event updateEvent(@RequestBody Event newEvent, @PathVariable Long eventId){
        return eventRepository.findById(eventId)
                .map(event -> {
                    event.setEventId(newEvent.getEventId());
                    event.setTitle(newEvent.getTitle());
                    event.setDescription(newEvent.getDescription());
                    event.setLocation(newEvent.getLocation());
                    event.setDateTime(newEvent.getDateTime());
                    event.setCapacity(newEvent.getCapacity());
                    event.setPrice(newEvent.getPrice());
                    event.setOrganizer(newEvent.getOrganizer());
                    return eventRepository.save(event);
                }).orElseThrow(()-> new EventNotFoundException(eventId));

    }

    @DeleteMapping("/delete/event/{eventId}")
    String deleteEvent (@PathVariable Long eventId){
        if(!eventRepository.existsById(eventId)){
            throw new EventNotFoundException(eventId);
        }
        eventRepository.deleteById(eventId);
        return "Event with id "+eventId+" has been deleted successfully.";
    }
}
