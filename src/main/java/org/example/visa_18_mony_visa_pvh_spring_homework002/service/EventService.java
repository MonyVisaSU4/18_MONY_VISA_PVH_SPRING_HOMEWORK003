package org.example.visa_18_mony_visa_pvh_spring_homework002.service;

import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.EventRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> getAllEvent(Integer limit, Integer offset);
    Event getById(Integer id);

    Event addEvent(EventRequest eventRequest);

    Event updateEvent(Integer id, EventRequest eventRequest);

    Event deleteEvent(Integer id);
}
