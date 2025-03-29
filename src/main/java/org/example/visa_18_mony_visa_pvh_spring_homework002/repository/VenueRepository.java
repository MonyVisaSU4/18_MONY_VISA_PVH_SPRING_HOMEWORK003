package org.example.visa_18_mony_visa_pvh_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.VenueRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Venue;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Select("""
        SELECT * FROM venues LIMIT #{limit} OFFSET #{offset};
    """)
    @Results(id = "venueMapper", value = {
            @Result(property = "id", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    })
    List<Venue> getAllVenue(Integer limit, Integer offset);

    @Select("""
        SELECT * FROM venues WHERE venue_id = #{id};
    """)
    @ResultMap("venueMapper")
    Venue getVenueById(Integer id);

    @Select("""
        INSERT INTO venues (venue_name, location) 
        VALUES (#{request.venueName}, #{request.location})
        RETURNING *;
    """)
    @ResultMap("venueMapper")
    Venue addVenue(@Param("request") VenueRequest venueRequest);

    @Select("""
        UPDATE venues SET venue_name=#{request.venueName}, location=#{request.location} WHERE venue_id = #{id}
        RETURNING *;
    """)
    @ResultMap("venueMapper")
    Venue updateVenues(Integer id, @Param("request") VenueRequest venueRequest);

    @Select("""
        DELETE FROM venues WHERE venue_id = #{id}
        RETURNING *;
    """)
    @ResultMap("venueMapper")
    Venue deleteVenues(Integer id);
}
