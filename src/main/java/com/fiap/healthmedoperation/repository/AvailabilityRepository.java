package com.fiap.healthmedoperation.repository;

import com.fiap.healthmedoperation.model.Availability;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailabilityRepository extends MongoRepository<Availability, String> {
    List<Availability> findByDoctorIdAndActiveTrue(String doctorId);
}
