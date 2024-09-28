package com.fiap.healthmedoperation.service;

import com.fiap.healthmedoperation.model.Appointment;
import com.fiap.healthmedoperation.model.Availability;
import com.fiap.healthmedoperation.repository.AppointmentRepository;
import com.fiap.healthmedoperation.repository.AvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    public Appointment createAppointment(Appointment appointment) {
        Availability availability = availabilityRepository.findById(appointment.getAvailabilityId())
                .orElseThrow(() -> new RuntimeException("Availability not found"));

        if (!availability.isActive()) {
            throw new RuntimeException("The selected time slot is no longer available.");
        }

        availability.setActive(false);
        availabilityRepository.save(availability);

        return appointmentRepository.save(appointment);

        /*
        // Cria a mensagem de notificação
        NotificationMessage notificationMessage = new NotificationMessage();
        notificationMessage.setDoctorId(appointment.getDoctorId());
        notificationMessage.setPatientId(appointment.getPatientId());
        notificationMessage.setAppointmentId(appointment.getId());
        notificationMessage.setDoctorName...

        // Envia a notificação para o tópico
        notificationProducer.sendNotification(notificationMessage);
         */
    }
}
