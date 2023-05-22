package com.example.hospital.services.visits;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Alternative;
import jakarta.inject.Named;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Date;

@Named
@ApplicationScoped
@Alternative
public class ComplexPageVisitsInformer implements PageVisitsInformer, Serializable {
    @Override
    public String getVisitsMessage() {
        var date = LocalDateTime.now();
        var day = date.getDayOfWeek();

        if (day == DayOfWeek.FRIDAY || (date.getDayOfMonth() == 24) && date.getMonthValue() == 12)
            return "We are very sorry, our hospital is at it's full capacity." +
                   " Only patients with life threatening symptoms are admitted.";
        return "Our hospital is accepting any patients, please feel free to contact us or register online.";
    }
}