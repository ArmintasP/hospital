package com.example.hospital.usecases.jpa;

import com.example.hospital.entities.Department;
import com.example.hospital.entities.Specialist;
import com.example.hospital.entities.common.Speciality;
import com.example.hospital.persistence.DepartmentsDAO;
import com.example.hospital.persistence.SpecialistsDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

@Model
public class SpecialistsByDepartment {
    @Inject
    private DepartmentsDAO departmentsDAO;

    @Inject
    private SpecialistsDAO specialistsDAO;

    @Getter
    @Setter
    private Department department;

    @Getter
    @Setter
    private Specialist newSpecialist = new Specialist();

    @Getter
    private final String defaultCountryCode = "LT";

    @PostConstruct
    public void init() {
        var requestParameters = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap();

        var departmentId = Integer.parseInt(requestParameters.get("departmentId"));
        department = departmentsDAO.findOne(departmentId);
    }

    public Speciality[] getSpecialities() {
        return Speciality.values();
    }

    @Transactional
    public void createSpecialist() {
        newSpecialist.setDepartment(department);
        specialistsDAO.persist(newSpecialist);
    }
}
