package com.example.hospital.persistence;

import com.example.hospital.entities.Department;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class DepartmentsDAO implements Serializable {

    @Inject
    private EntityManager em;

    public void persist(Department department) {
        this.em.persist(department);
    }

    public List<Department> getAll() {
        return em.createQuery(
            """
                SELECT D
                FROM Department AS D
            """,
            Department.class)
            .getResultList();
    }

    public Department findOne(Integer id) {
        return em.find(Department.class, id);
    }

    public Department update(Department department) {
        return em.merge(department);
    }
}
