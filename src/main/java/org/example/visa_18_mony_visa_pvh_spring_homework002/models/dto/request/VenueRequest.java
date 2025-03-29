package org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    private String venueName;
    private String location;
}
