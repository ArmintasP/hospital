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
                        "SELECT S\n" +
                        "FROM\n" +
                        "    Specialist AS S,\n" +
                        "    Department AS D\n" +
                        "WHERE\n" +
                        "    D.name LIKE :departmentName AND\n" +
                        "    D.id = S.department.id\n",
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
