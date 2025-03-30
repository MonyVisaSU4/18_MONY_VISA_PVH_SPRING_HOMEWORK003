package org.example.visa_18_mony_visa_pvh_spring_homework002.controller;

import org.example.visa_18_mony_visa_pvh_spring_homework002.exception.BlankInputException;
import org.example.visa_18_mony_visa_pvh_spring_homework002.exception.NotFoundException;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.EventRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.respone.ApiRespone;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.respone.ErrorRespone;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Event;
import org.example.visa_18_mony_visa_pvh_spring_homework002.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/event")
    public ResponseEntity<ApiRespone<List<Event>>> show(@RequestParam(defaultValue = "5") Integer limit, @RequestParam(defaultValue = "0") Integer offset){
        ApiRespone<List<Event>> apiRespone = ApiRespone.<List<Event>>builder()
                .message("All event have been successfully fetched.")
                .payload(eventService.getAllEvent(limit, offset))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiRespone);
    }

    @GetMapping("/event/{event-id}")
    public ResponseEntity<?> getbyid(@PathVariable("event-id") Integer id){
        ApiRespone<Event> apiRespone = ApiRespone.<Event>builder()
                .message("All event have been successfully fetched.")
                .payload(eventService.getById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
//        try{
            if(apiRespone.getPayload() == null){
                throw new NotFoundException("This id: " + id + " Not Found");
            }
//        }
//        catch (NotFoundException ex){
//            return new ResponseEntity<>(new ErrorRespone(ex.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
//        }
        return ResponseEntity.ok(apiRespone);
    }

    @PostMapping("/event")
    public ResponseEntity<ApiRespone<Event>> add(@RequestBody EventRequest eventRequest){
        if(eventRequest.getName().isEmpty() && eventRequest.getDate() == null && eventRequest.getVenue() == null && eventRequest.getAttendeesId() == null){
            throw new BlankInputException("Name & Date & Venue & Attendees Should not be blank");
        } else if(eventRequest.getName().isEmpty()) {
            throw new BlankInputException("Event name cannot be empty");
        } else if(eventRequest.getDate() == null) {
            throw new BlankInputException("Event date must be specified");
        } else if(eventRequest.getVenue() == null) {
            throw new BlankInputException("Event venue cannot be null");
        } else if(eventRequest.getAttendeesId() == null) {
            throw new BlankInputException("Attendees list cannot be null");
        }
        ApiRespone<Event> apiRespone = ApiRespone.<Event>builder()
                .message("All event have been successfully fetched.")
                .payload(eventService.addEvent(eventRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiRespone);
    }

    @PutMapping("/event/{event-id}")
    public ResponseEntity<ApiRespone<Event>> update(@PathVariable("event-id") Integer id ,@RequestBody EventRequest eventRequest){
        if(eventRequest.getName().isEmpty() && eventRequest.getDate() == null && eventRequest.getVenue() == null && eventRequest.getAttendeesId() == null){
            throw new BlankInputException("Name & Date & Venue & Attendees Should not be blank");
        } else if(eventRequest.getName().isEmpty()) {
            throw new BlankInputException("Event name cannot be empty");
        } else if(eventRequest.getDate() == null) {
            throw new BlankInputException("Event date must be specified");
        } else if(eventRequest.getVenue() == null) {
            throw new BlankInputException("Event venue cannot be null");
        } else if(eventRequest.getAttendeesId() == null) {
            throw new BlankInputException("Attendees list cannot be null");
        }
        ApiRespone<Event> apiRespone = ApiRespone.<Event>builder()
                .message("All event have been successfully fetched.")
                .payload(eventService.updateEvent(id, eventRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        if(apiRespone.getPayload() == null){
            throw new NotFoundException("This id: " + id + " Not Found");
        }
        return ResponseEntity.ok(apiRespone);
    }

    @DeleteMapping("/event/{event-id}")
    public ResponseEntity<ApiRespone<Event>> delete(@PathVariable("event-id") Integer id){
        ApiRespone<Event> apiRespone = ApiRespone.<Event>builder()
                .message("All event have been successfully fetched.")
                .payload(eventService.deleteEvent(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        if(apiRespone.getPayload() == null){
            throw new NotFoundException("This id: " + id + " Not Found");
        }
        return ResponseEntity.ok(apiRespone);
    }

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<?> handler(NotFoundException ex){
//        return new ResponseEntity<>(new ErrorRespone(ex.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
//    }
}
