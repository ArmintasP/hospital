package com.example.hospital.usecases.jpa;

import com.example.hospital.entities.Department;
import com.example.hospital.persistence.DepartmentsDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Model
public class Departments {
    @Inject
    private DepartmentsDAO departmentsDao;

    @Getter
    private List<Department> departments;

    @Getter
    @Setter
    private Department newDepartment = new Department();

    @PostConstruct
    public void init() {
        departments = departmentsDao.getAll();
    }

    @Transactional
    public void createDepartment() {
        departmentsDao.persist(newDepartment);
    }
}
