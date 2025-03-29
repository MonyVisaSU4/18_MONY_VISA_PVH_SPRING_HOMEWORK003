package org.example.visa_18_mony_visa_pvh_spring_homework002.controller;

import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.request.VenueRequest;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.entity.Venue;
import org.example.visa_18_mony_visa_pvh_spring_homework002.models.dto.respone.ApiRespone;
import org.example.visa_18_mony_visa_pvh_spring_homework002.service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VenueController {
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping("/venues")
    public ResponseEntity<ApiRespone<List<Venue>>> show(@RequestParam(defaultValue = "5") Integer limit, @RequestParam(defaultValue = "0") Integer offset){
        ApiRespone<List<Venue>> apiRespone = ApiRespone.<List<Venue>>builder()
                .message("All venues have been successfully fetched.")
                .payload(venueService.getAllVenue(limit, offset))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiRespone);
    }

    @GetMapping("/venues/{venue-id}")
    public ResponseEntity<ApiRespone<Venue>> search(@PathVariable("venue-id") Integer id){
        ApiRespone<Venue> apiRespone = ApiRespone.<Venue>builder()
                .message("All venues have been successfully fetched.")
                .payload(venueService.getVenueById(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiRespone);
    }

    @PostMapping("/venues")
    public ResponseEntity<ApiRespone<Venue>> add(@RequestBody VenueRequest venueRequest){
        ApiRespone<Venue> apiRespone = ApiRespone.<Venue>builder()
                .message("All venues have been successfully fetched.")
                .payload(venueService.addVenue(venueRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiRespone);
    }

    @PutMapping("/venues/{venue-id}")
    public ResponseEntity<ApiRespone<Venue>> update(@PathVariable("venue-id") Integer id, VenueRequest venueRequest){
        ApiRespone<Venue> apiRespone = ApiRespone.<Venue>builder()
                .message("All venues have been successfully fetched.")
                .payload(venueService.updateVenues(id, venueRequest))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiRespone);
    }

    @DeleteMapping("/venues/{venue-id}")
    public ResponseEntity<ApiRespone<Venue>> delete(@PathVariable("venue-id") Integer id){
        ApiRespone<Venue> apiRespone = ApiRespone.<Venue>builder()
                .message("All venues have been successfully fetched.")
                .payload(venueService.deleteVenues(id))
                .status(HttpStatus.OK)
                .time(LocalDateTime.now()).build();
        return ResponseEntity.ok(apiRespone);
    }
}
