package org.example.visa_18_mony_visa_pvh_spring_homework002.service;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.VenueRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Venue;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenue(Integer limit, Integer offset);
    Venue getVenueById(Integer id);
    Venue addVenue(VenueRequest venueRequest);
    Venue updateVenues(Integer id, VenueRequest venueRequest);
    Venue deleteVenues(Integer id);
}
