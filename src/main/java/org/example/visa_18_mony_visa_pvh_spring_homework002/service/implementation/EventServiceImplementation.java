package org.example.visa_18_mony_visa_pvh_spring_homework002.service.implementation;

import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.EventRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Event;
import org.example.visa_18_mony_visa_pvh_spring_homework002.repository.EventRepository;
import org.example.visa_18_mony_visa_pvh_spring_homework002.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImplementation implements EventService {
    private final EventRepository repository;

    public EventServiceImplementation(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Event> getAllEvent(Integer limit, Integer offset) {
        return repository.getAllEvent(limit, offset);
    }

    @Override
    public Event getById(Integer id) {
        return repository.getbyid(id);
    }

    @Override
    public Event addEvent(EventRequest eventRequest) {
        return repository.addEvent(eventRequest);
    }

    @Override
    public Event updateEvent(Integer id, EventRequest eventRequest) {
        return repository.updateEvent(id, eventRequest);
    }

    @Override
    public Event deleteEvent(Integer id) {
        return repository.delelteEvent(id);
    }
}
