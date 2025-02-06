package com.jh.tds.ems.service;

import com.jh.tds.ems.model.Event;
import com.jh.tds.ems.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getActiveEvents() {
        return eventRepository.findByIsActiveTrue();
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(String id) {
        return eventRepository.findById(id).orElse(null);
    }

    public void deactivateEvent(String id) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event != null) {
            event.setActive(false);
            eventRepository.save(event);
        }
    }
}
