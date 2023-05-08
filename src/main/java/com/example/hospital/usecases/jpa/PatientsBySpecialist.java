package com.example.hospital.usecases.jpa;

import com.example.hospital.entities.Patient;
import com.example.hospital.entities.Specialist;
import com.example.hospital.persistence.PatientsDAO;
import com.example.hospital.persistence.SpecialistsDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

@Model
public class PatientsBySpecialist {
    @Inject
    private SpecialistsDAO specialistsDAO;

    @Inject
    private PatientsDAO patientsDAO;

    @Getter
    @Setter
    private Specialist specialist;

    @Getter
    @Setter
    private Patient newPatient = new Patient();

    @Getter
    private final String defaultCountryCode = "LT";

    @PostConstruct
    public void init() {
        var requestParameters = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        var specialistId = Integer.parseInt(requestParameters.get("specialistId"));
        specialist = specialistsDAO.findOne(specialistId);
    }

    @Transactional
    public void assignToSpecialist() {
        newPatient.getSpecialists().add(specialist);
        patientsDAO.persist(newPatient);
    }
}
