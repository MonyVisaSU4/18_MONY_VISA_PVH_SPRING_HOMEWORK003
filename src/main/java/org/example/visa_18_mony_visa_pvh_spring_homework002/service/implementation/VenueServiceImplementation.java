package org.example.visa_18_mony_visa_pvh_spring_homework002.service.implementation;

import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.VenueRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Venue;
import org.example.visa_18_mony_visa_pvh_spring_homework002.repository.VenueRepository;
import org.example.visa_18_mony_visa_pvh_spring_homework002.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImplementation implements VenueService {
    private final VenueRepository repository;

    public VenueServiceImplementation(VenueRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Venue> getAllVenue(Integer limit, Integer offset) {
        return repository.getAllVenue(limit, offset);
    }

    @Override
    public Venue getVenueById(Integer id) {
        return repository.getVenueById(id);
    }

    @Override
    public Venue addVenue(VenueRequest venueRequest) {
        return repository.addVenue(venueRequest);
    }

    @Override
    public Venue updateVenues(Integer id, VenueRequest venueRequest) {
        return repository.updateVenues(id, venueRequest);
    }

    @Override
    public Venue deleteVenues(Integer id) {
        return repository.deleteVenues(id);
    }
}
