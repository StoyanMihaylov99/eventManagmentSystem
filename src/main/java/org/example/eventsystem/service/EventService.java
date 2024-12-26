package org.example.eventsystem.service;

import org.example.eventsystem.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private EventRepository eventRepository;
    private ModelMapper modelMapper;

    public EventService(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }


}
