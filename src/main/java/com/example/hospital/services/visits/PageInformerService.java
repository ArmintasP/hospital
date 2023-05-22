package com.example.hospital.services.visits;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@SessionScoped
public class PageInformerService implements Serializable {
    @Inject
    PageVisitsInformer pageVisitsInformer;

    @Inject
    SpecialistInformer specialistInformer;

    public String getInformerMessage() {
        return pageVisitsInformer.getVisitsMessage();
    }

    public String specialistMessage() {
        return specialistInformer.getSpecialistMessage();
    }
}
