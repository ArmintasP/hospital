package com.example.hospital.usecases;

import com.example.hospital.entities.Specialist;
import com.example.hospital.entities.common.Speciality;
import com.example.hospital.services.SpecialistStatusReceiver;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Named
@SessionScoped
public class SpecialistStatus implements Serializable {
    @Inject
    SpecialistStatusReceiver specialistStatusReceiver;

    private CompletableFuture<String> specialistStatusTask = null;

    public String askForStatus(Specialist specialist) {
        specialistStatusTask = CompletableFuture.supplyAsync(() ->
                specialistStatusReceiver.getStatus(specialist));

        return "specialist?faces-redirect=true&amp;specialistId=" + specialist.getId().toString();
    }

    public boolean isWaitingForStatus() {
        return specialistStatusTask != null &&
               !specialistStatusTask.isDone();
    }

    public String getStatus() throws ExecutionException, InterruptedException {
        if (specialistStatusTask == null) {
            return "";
        }
        else if (isWaitingForStatus()) {
            return "Waiting for a response from the specialist.";
        }
        return specialistStatusTask.get();
    }
}
