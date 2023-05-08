package com.example.hospital.services;

import com.example.hospital.entities.common.Speciality;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.Map;

@SessionScoped
public class ReasonValidation implements Serializable {

    private final Map<Speciality, String> KEYWORDS= Map.of(
            Speciality.DERMATOLOGY,"skin",
            Speciality.PATHOLOGY, "fatigue",
            Speciality.PSYCHIATRY, "mind",
            Speciality.NEUROLOGY, "nerve",
            Speciality.FAMILY_MEDICINE, "ache",
            Speciality.EMERGENCY_MEDICINE, "pain");

    public boolean isValidReason(String reason, Speciality speciality){
        var keyword = KEYWORDS.get(speciality);
        return reason.toLowerCase().contains(keyword);
    }
}
