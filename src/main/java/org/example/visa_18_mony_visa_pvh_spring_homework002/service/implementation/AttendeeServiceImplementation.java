package org.example.visa_18_mony_visa_pvh_spring_homework002.service.implementation;

import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.AttendeeRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Attendee;
import org.example.visa_18_mony_visa_pvh_spring_homework002.repository.AttendeeRepository;
import org.example.visa_18_mony_visa_pvh_spring_homework002.service.AttendeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImplementation implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    public AttendeeServiceImplementation(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Attendee> getAll(Integer limit, Integer offset) {
        return attendeeRepository.getAll(limit, offset);
    }

    @Override
    public Attendee getById(Integer id) {
        return attendeeRepository.getById(id);
    }

    @Override
    public Attendee add(AttendeeRequest attendeeRequest) {
        return attendeeRepository.add(attendeeRequest);
    }

    @Override
    public Attendee update(Integer id, AttendeeRequest attendeeRequest) {
        return attendeeRepository.update(id, attendeeRequest);
    }

    @Override
    public Attendee delete(Integer id) {
        return attendeeRepository.delete(id);
    }
}
