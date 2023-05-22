package com.example.hospital.services.visits;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Specializes;

@Specializes
@RequestScoped
public class SpecializedSpecialistInformer extends SpecialistInformer {
    @Override
    public String getSpecialistMessage() {
        return "A talented specialist, best in the country";
    }
}
