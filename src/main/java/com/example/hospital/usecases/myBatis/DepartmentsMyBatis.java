package com.example.hospital.usecases.myBatis;

import com.example.hospital.mybatis.dao.DepartmentMapper;
import com.example.hospital.mybatis.model.Department;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Model
public class DepartmentsMyBatis {
    @Inject
    private DepartmentMapper departmentMapper;

    @Getter
    private List<Department> departments;

    @Getter
    @Setter
    private Department newDepartment = new Department();

    @PostConstruct
    public void init() {
        getAllDepartments();
    }

    private void getAllDepartments() {
        departments = departmentMapper.selectAll();
    }

    @Transactional
    public String create() {
        departmentMapper.insert(newDepartment);
        return "/myBatis/departments?faces-redirect=true";
    }
}

