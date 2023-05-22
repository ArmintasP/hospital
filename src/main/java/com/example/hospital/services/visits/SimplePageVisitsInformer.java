package com.example.hospital.services.visits;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ApplicationScoped
public class SimplePageVisitsInformer implements PageVisitsInformer, Serializable {
    @Override
    public String getVisitsMessage() {
        return "Welcome to Hospital Jakartium! We are glad you have visited our page.";
    }
}
