package org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendee {
    private Integer id;
    private String name;
    private String email;
}
