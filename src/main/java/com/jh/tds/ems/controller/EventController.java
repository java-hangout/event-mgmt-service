package com.jh.tds.ems.controller;

import com.jh.tds.ems.model.Event;
import com.jh.tds.ems.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/fetch/active")
    public List<Event> getAllActiveEvents() {
        return eventService.getActiveEvents();
    }

    @GetMapping("/fetch/bu/{buName}")
    public List<Event> getAllBUActiveEvents(@PathVariable String buName) {
        return eventService.getBUActiveEvents(buName);
    }

    @GetMapping("/fetch/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/fetch/id/{id}")
    public Event getEventById(@PathVariable String id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/deactivate/{id}")
    public void deactivateEvent(@PathVariable String id) {
        eventService.deactivateEvent(id);
    }

}
