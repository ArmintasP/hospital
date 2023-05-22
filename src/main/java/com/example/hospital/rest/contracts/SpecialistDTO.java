package com.example.hospital.rest.contracts;

import com.example.hospital.entities.common.Speciality;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpecialistDTO {
    @Size(min = 1, max = 60)
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    private Integer departmentId;

    @Size(min = 2, max = 2)
    private String countryCode;

    private String nationalId;
}