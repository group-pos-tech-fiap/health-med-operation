package com.fiap.healthmedoperation.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "availabilities")
public class Availability {
    @Id
    private String id;
    private String doctorId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean active;
}
