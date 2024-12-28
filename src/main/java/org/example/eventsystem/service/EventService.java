package org.example.eventsystem.service;
import org.example.eventsystem.model.dto.EventDTO;
import org.example.eventsystem.model.entity.Event;
import org.example.eventsystem.repository.EventRepository;
import org.example.eventsystem.utils.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    private EventRepository eventRepository;
    private ModelMapper modelMapper;

    public EventService(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EventDTO> getEventByTitle(String title) {
        return Optional.of(modelMapper.map(eventRepository.findByTitle(title), EventDTO.class));
    }

    public Optional<List<EventDTO>> getEventsByCategory(Category category) {
        return Optional.of(Arrays.asList(modelMapper.map(eventRepository.findEventsByCategory(category), EventDTO[].class)));
    }

    public boolean deleteEventById(String id) {
        if (eventRepository.findById(id).isPresent()) {
            eventRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public String createEvent(EventDTO eventDTO) {
        return eventRepository.save(modelMapper.map(eventDTO, Event.class)).getId();
    }

    public EventDTO updateEvent(EventDTO eventDTO) {
        Optional<Event> existingEvent = eventRepository.findById(eventDTO.getId());
        if (existingEvent.isPresent()) {
            Event eventToSave = existingEvent.get();
            modelMapper.map(eventDTO, existingEvent);
            eventRepository.save(eventToSave);
            return modelMapper.map(eventRepository.findById(eventToSave.getId()), EventDTO.class);
        }
        return null;
    }
}
