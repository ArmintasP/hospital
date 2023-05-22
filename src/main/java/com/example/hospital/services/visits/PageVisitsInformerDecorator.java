package com.example.hospital.services.visits;

import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;

import java.io.Serializable;

@Decorator
public class PageVisitsInformerDecorator implements PageVisitsInformer, Serializable {
    @Inject
    @Delegate
    @Any
    PageVisitsInformer pageVisitsInformer;

    private int visits = 0;

    public void countVisit() {
        visits += 1;
    }

    public String getVisitsMessage() {
        countVisit();

        if (visits > 4){
            return "Our hospital is very busy, please try registering online before calling our call centre.";
        }

        return pageVisitsInformer.getVisitsMessage();
    }
}
