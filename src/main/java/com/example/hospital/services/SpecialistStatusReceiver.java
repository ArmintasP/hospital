package com.example.hospital.services;

import com.example.hospital.entities.Specialist;
import com.example.hospital.entities.common.Speciality;
import jakarta.enterprise.context.ApplicationScoped;

import java.io.Serializable;
import java.time.LocalDateTime;

@ApplicationScoped
public class SpecialistStatusReceiver implements Serializable {

    public String getStatus(Specialist specialist) {
        try {
            Thread.sleep(2000); // Simulate intensive work
        } catch (InterruptedException e) {
        }

        if (specialist.getSpeciality() == Speciality.PSYCHIATRY ||
            specialist.getSpeciality() == Speciality.NEUROLOGY) {
            return "Busy";
        }
        var hours = LocalDateTime.now().getHour();

        if (hours > 10 && hours < 16) {
            return "Available";
        }

        return "Available only for online consultations";
    }
}
