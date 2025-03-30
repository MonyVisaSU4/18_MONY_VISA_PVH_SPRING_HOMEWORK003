package org.example.visa_18_mony_visa_pvh_spring_homework002.controller;

import org.example.visa_18_mony_visa_pvh_spring_homework002.exception.BlankInputException;
import org.example.visa_18_mony_visa_pvh_spring_homework002.exception.NotFoundException;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.AttendeeRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.respone.ApiRespone;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.respone.ErrorRespone;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Attendee;
import org.example.visa_18_mony_visa_pvh_spring_homework002.service.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AttendeeController {
    private final AttendeeService attendeeService;

    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping("/attendees")
    public ResponseEntity<ApiRespone<List<Attendee>>> show(@RequestParam(defaultValue = "5") Integer limit, @RequestParam(defaultValue = "0") Integer offset){
        ApiRespone<List<Attendee>> apiRespone = ApiRespone.<List<Attendee>>builder()
                .message("All attendees have been successfully fetched.")
                .payload(attendeeService.getAll(limit, offset))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiRespone);
    }

    @GetMapping("/attendees/{attendees-id}")
    public ResponseEntity<?> search(@PathVariable("attendees-id") Integer id){
        ApiRespone<Attendee> apiRespone = ApiRespone.<Attendee>builder()
                .message("All attendees have been successfully fetched.")
                .payload(attendeeService.getById(id))
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

    @PostMapping("/attendees")
    public ResponseEntity<ApiRespone<Attendee>> add(@RequestBody AttendeeRequest attendeeRequest){
        if(attendeeRequest.getName().isEmpty() && attendeeRequest.getEmail().isEmpty()){
            throw new BlankInputException("Name & Email Should not be blank");
        } else if(attendeeRequest.getName().isEmpty()) {
            throw new BlankInputException("Name Should not blank");
        } else if(attendeeRequest.getEmail().isEmpty()) {
            throw new BlankInputException("Email Should not blank");
        }
        ApiRespone<Attendee> apiRespone = ApiRespone.<Attendee>builder()
                .message("All attendees have been successfully fetched.")
                .payload(attendeeService.add(attendeeRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiRespone);
    }

    @PutMapping("/attendees/{attendees-id}")
    public ResponseEntity<ApiRespone<Attendee>> update(@PathVariable("attendees-id") Integer id, AttendeeRequest attendeeRequest){
        if(attendeeRequest.getName().isEmpty() && attendeeRequest.getEmail().isEmpty()){
            throw new BlankInputException("Name & Email Should not be blank");
        } else if(attendeeRequest.getName().isEmpty()) {
            throw new BlankInputException("Name Should not blank");
        } else if(attendeeRequest.getEmail().isEmpty()) {
            throw new BlankInputException("Email Should not blank");
        }
        ApiRespone<Attendee> apiRespone = ApiRespone.<Attendee>builder()
                .message("All attendees have been successfully fetched.")
                .payload(attendeeService.update(id, attendeeRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        if(apiRespone.getPayload() == null){
            throw new NotFoundException("This id: " + id + " Not Found");
        }
        return ResponseEntity.ok(apiRespone);
    }

    @DeleteMapping("/attendees/{attendees-id}")
    public ResponseEntity<ApiRespone<Attendee>> delete(@PathVariable("attendees-id") Integer id){
        ApiRespone<Attendee> apiRespone = ApiRespone.<Attendee>builder()
                .message("All attendees have been successfully fetched.")
                .payload(attendeeService.delete(id))
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
