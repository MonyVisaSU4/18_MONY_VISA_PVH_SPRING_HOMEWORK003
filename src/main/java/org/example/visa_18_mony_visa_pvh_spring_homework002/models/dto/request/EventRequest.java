package org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Attendee;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Venue;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    private String name;
    private Date date;
    private Integer venue;
    private List<Integer> attendeesId;
}
