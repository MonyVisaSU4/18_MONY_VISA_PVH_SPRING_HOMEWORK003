package org.example.visa_18_mony_visa_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.EventRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Event;

import java.util.List;

@Mapper
public interface EventRepository {
    @Select("""
        SELECT * FROM events
        LIMIT #{limit}
        OFFSET #{offset};
    """)
    @Results(id = "eventMapper", value = {
            @Result(property = "id", column = "event_id"),
            @Result(property = "name", column = "event_name"),
            @Result(property = "date", column = "event_date"),
            @Result(property = "venue", column = "venue_id",
                one = @One(select = "org.example.visa_18_mony_visa_pvh_spring_homework002.repository.VenueRepository.getVenueById")
            ),
            @Result(property = "attendees", column = "event_id",
                many = @Many(select = "org.example.visa_18_mony_visa_pvh_spring_homework002.repository.AttendeeRepository.getbyEventId")
            )
    })
    List<Event> getAllEvent(Integer limit, Integer offset);

    @Select("""
        SELECT * FROM events
        WHERE event_id = #{id};
    """)
    @ResultMap("eventMapper")
    Event getbyid(Integer id);

    @Select("""
        
    """)
    @ResultMap("eventMapper")
    Event addEvent(@Param("request") EventRequest eventRequest);

    @Select("""
        
    """)
    @ResultMap("eventMapper")
    Event delelteEvent(Integer id);

    @Select("""
        
    """)
    @ResultMap("eventMapper")
    Event updateEvent(Integer id, @Param("request") EventRequest eventRequest);
}
