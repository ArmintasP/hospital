package com.example.hospital.persistence;

import com.example.hospital.entities.Specialist;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class SpecialistsDAO implements Serializable {

    @Inject
    private EntityManager em;

    public void persist(Specialist specialist) {

        this.em.persist(specialist);
    }

    public List<Specialist> getByDepartment(String departmentName) {
        return em.createQuery(
                 """
                 SELECT S
                 FROM
                     Specialist AS S,
                     Department AS D
                 WHERE
                     D.name LIKE :departmentName AND
                     D.id = S.department.id
                 """,
                Specialist.class)
            .setParameter("departmentName", departmentName)
            .getResultList();
    }

    public Specialist findOne(Integer id) {
        return em.find(Specialist.class, id);
    }

    public Specialist update(Specialist specialist) {
        return em.merge(specialist);
    }
}
