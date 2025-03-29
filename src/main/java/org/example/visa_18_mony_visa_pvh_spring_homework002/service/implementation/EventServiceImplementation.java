package org.example.visa_18_mony_visa_pvh_spring_homework002.service.implementation;

import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.EventRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Event;
import org.example.visa_18_mony_visa_pvh_spring_homework002.repository.AttendeeRepository;
import org.example.visa_18_mony_visa_pvh_spring_homework002.repository.EventRepository;
import org.example.visa_18_mony_visa_pvh_spring_homework002.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EventServiceImplementation implements EventService {
    private final EventRepository repository;
    private final AttendeeRepository attendeeRepository;

    public EventServiceImplementation(EventRepository repository, AttendeeRepository attendeeRepository) {
        this.repository = repository;
        this.attendeeRepository = attendeeRepository;
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
        Event event = repository.addEvent(eventRequest);
        for(Integer attendeeId : eventRequest.getAttendeesId()){
            attendeeRepository.addEventIdAndAttendee(event.getId(),attendeeId);
        }
        return repository.getbyid(event.getId());
    }

    @Override
    public Event updateEvent(Integer id, EventRequest eventRequest) {
        Event event = repository.updateEvent(id, eventRequest);
        for(Integer attendeeId : eventRequest.getAttendeesId()){
            attendeeRepository.updateEventIdAndAttendee(event.getId(),attendeeId);
        }
        return repository.getbyid(event.getId());
    }

    @Override
    public Event deleteEvent(Integer id) {

        return null;
    }
}
