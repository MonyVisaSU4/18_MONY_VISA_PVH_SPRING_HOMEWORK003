package org.example.visa_18_mony_visa_pvh_spring_homework002.service;

import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.AttendeeRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.VenueRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Attendee;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Venue;
import org.example.visa_18_mony_visa_pvh_spring_homework002.repository.AttendeeRepository;

import java.util.List;

public interface AttendeeService {
    List<Attendee> getAll(Integer limit, Integer offset);

    Attendee getById(Integer id);

    Attendee add(AttendeeRequest attendeeRequest);

    Attendee update(Integer id, AttendeeRequest attendeeRequest);

    Attendee delete(Integer id);
}
