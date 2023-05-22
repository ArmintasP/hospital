package com.example.hospital.services.visits;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@SessionScoped
public class SpecialistInformer implements Serializable {
    public String getSpecialistMessage() {
        return "A very good specialist";
    }
}
