package com.example.hospital.entities;

import com.example.hospital.entities.common.Specialty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@EqualsAndHashCode(of = {"countryCode", "nationalId"})
@Getter
@Setter
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Size(min = 2, max = 2)
    private String countryCode;

    @Column(nullable = false, unique = true)
    private String nationalId;

    @Column(nullable = false)
    @Size(min = 1, max = 60)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "DepartmentId")
    private Department department;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @ManyToMany(mappedBy = "specialists")
    private List<Patient> patients = new ArrayList<>();

    @Version
    private Integer version;
}
