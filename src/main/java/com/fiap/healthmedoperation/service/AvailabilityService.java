package com.fiap.healthmedoperation.service;

import com.fiap.healthmedoperation.model.Availability;
import com.fiap.healthmedoperation.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Availability createAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public Availability updateAvailability(String id, Availability availability) {
        availability.setId(id);
        return availabilityRepository.save(availability);
    }

    public List<Availability> getAvailabilitiesByDoctor(String doctorId) {
        return availabilityRepository.findByDoctorIdAndActiveTrue(doctorId);
    }
}
