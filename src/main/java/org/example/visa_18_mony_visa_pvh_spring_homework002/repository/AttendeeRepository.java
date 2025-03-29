package org.example.visa_18_mony_visa_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.AttendeeRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.VenueRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Attendee;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Venue;

import java.util.List;

@Mapper
public interface AttendeeRepository {
    @Select("""
        SELECT * FROM attendees LIMIT #{limit} OFFSET #{offset};
    """)
    @Results(id = "attendeesMapper", value = {
            @Result(property = "id", column = "attendee_id"),
            @Result(property = "name", column = "attendee_name")
    })
    List<Attendee> getAll(Integer limit, Integer offset);

    @Select("""
        SELECT * FROM attendees WHERE attendee_id = #{id};
    """)
    @ResultMap("attendeesMapper")
    Attendee getById(Integer id);

    @Select("""
        INSERT INTO attendees (attendee_name, email) 
        VALUES (#{request.name}, #{request.email})
        RETURNING *;
    """)
    @ResultMap("attendeesMapper")
    Attendee add(@Param("request") AttendeeRequest attendeeRequest);

    @Select("""
        SELECT a.attendee_id,a.attendee_name,a.email FROM event_attendee INNER JOIN attendees a on event_attendee.attendee_id = a.attendee_id
        WHERE event_id = #{id};
    """)
    @ResultMap("attendeesMapper")
    Attendee getbyEventId(Integer id);

    @Select("""
        UPDATE attendees SET attendee_name=#{request.name}, email=#{request.email} WHERE attendee_id = #{id}
        RETURNING *;
    """)
    @ResultMap("attendeesMapper")
    Attendee update(Integer id, @Param("request") AttendeeRequest attendeeRequest);

    @Select("""
        DELETE FROM attendees WHERE attendee_id = #{id}
        RETURNING *;
    """)
    @ResultMap("attendeesMapper")
    Attendee delete(Integer id);
}
