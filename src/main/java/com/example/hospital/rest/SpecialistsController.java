package com.example.hospital.rest;

import com.example.hospital.entities.Specialist;
import com.example.hospital.interceptors.LoggedInvocation;
import com.example.hospital.persistence.DepartmentsDAO;
import com.example.hospital.persistence.SpecialistsDAO;
import com.example.hospital.rest.contracts.SpecialistDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;

@RequestScoped
@Path("/specialists")
@LoggedInvocation
public class SpecialistsController{

    @Inject
    @Setter
    @Getter
    private SpecialistsDAO specialistsDAO;

    @Inject
    @Setter
    @Getter
    private DepartmentsDAO departmentsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        var specialist = specialistsDAO.findOne(id);
        if (specialist == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        var specialistDTO = new SpecialistDTO();
        specialistDTO.setFullName(specialist.getFullName());
        specialistDTO.setSpeciality(specialist.getSpeciality());
        specialistDTO.setDepartmentId(specialist.getDepartment().getId());

        return Response.ok(specialistDTO).build();
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(SpecialistDTO specialistDTO) {
        var specialist = new Specialist();

        var department = departmentsDAO.findOne(specialistDTO.getDepartmentId());
        if (department == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        specialist.setDepartment(department);
        specialist.setFullName(specialistDTO.getFullName());
        specialist.setSpeciality(specialistDTO.getSpeciality());
        specialist.setNationalId(specialistDTO.getNationalId());
        specialist.setCountryCode(specialistDTO.getCountryCode());

        specialistsDAO.update(specialist);

        return Response.ok().build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateById(@PathParam("id") final Integer id, SpecialistDTO specialistDTO) {
        try {
            var specialist = specialistsDAO.findOne(id);
            if (specialist == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            var department = departmentsDAO.findOne(specialistDTO.getDepartmentId());
            if (department == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            specialist.setDepartment(department);
            specialist.setFullName(specialistDTO.getFullName());
            specialist.setSpeciality(specialistDTO.getSpeciality());
            specialist.setNationalId(specialistDTO.getNationalId());
            specialist.setCountryCode(specialistDTO.getCountryCode());

            specialistsDAO.persist(specialist);

            return Response.ok().build();

        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/slow/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response slow(@PathParam("id") final Integer id, SpecialistDTO specialistDTO) {
        try {
            var specialist = specialistsDAO.findOne(id);
            if (specialist == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            var department = departmentsDAO.findOne(specialistDTO.getDepartmentId());
            if (department == null) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            specialist.setDepartment(department);
            specialist.setFullName(specialistDTO.getFullName());
            specialist.setSpeciality(specialistDTO.getSpeciality());
            specialist.setNationalId(specialistDTO.getNationalId());
            specialist.setCountryCode(specialistDTO.getCountryCode());

            try{
                Thread.sleep(5000);
            }catch (InterruptedException e){}

            specialistsDAO.persist(specialist);

            return Response.ok().build();

        } catch (OptimisticLockException e) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}