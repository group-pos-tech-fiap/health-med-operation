package com.fiap.healthmedoperation.controller;

import com.fiap.healthmedoperation.model.Availability;
import com.fiap.healthmedoperation.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/availabilities")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @PostMapping
    public ResponseEntity<Availability> createAvailability(@RequestBody Availability availability) {
        Availability createdAvailability = availabilityService.createAvailability(availability);
        return ResponseEntity.ok(createdAvailability);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Availability> updateAvailability(@PathVariable String id, @RequestBody Availability availability) {
        Availability updatedAvailability = availabilityService.updateAvailability(id, availability);
        return ResponseEntity.ok(updatedAvailability);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Availability>> getAvailabilitiesByDoctor(@PathVariable String doctorId) {
        List<Availability> availabilities = availabilityService.getAvailabilitiesByDoctor(doctorId);
        return ResponseEntity.ok(availabilities);
    }
}
