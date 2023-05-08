package com.example.hospital.persistence;

import com.example.hospital.entities.Patient;
import com.example.hospital.entities.Specialist;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class PatientsDAO implements Serializable {

    @Inject
    private EntityManager em;

    public void persist(Patient patient) {
        this.em.persist(patient);
    }

    public List<Patient> getBySpecialist(Integer specialistId) {
        return em.find(Specialist.class, specialistId).getPatients();
    }

    public Patient findOne(Integer id) {
        return em.find(Patient.class, id);
    }

    public Patient update(Patient patient) {
        return em.merge(patient);
    }
}
