package org.example.eventsystem.service;

import org.example.eventsystem.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


}
