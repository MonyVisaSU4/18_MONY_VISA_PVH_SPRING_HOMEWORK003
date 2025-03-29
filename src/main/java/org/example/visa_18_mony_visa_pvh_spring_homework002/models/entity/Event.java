package org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Integer id;
    private String name;
    private String date;
    private Venue venue;
    private List<Attendee> attendees;
}
