package com.example.hospital.entities;

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
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(min = 2, max = 2)
    private String countryCode;

    @Column(nullable = false, unique = true)
    private String nationalId;

    @Column(nullable = false)
    @Size(min = 1, max = 60)
    private String fullName;

    @ManyToMany
    @JoinTable(name = "AssignedPatients")
    private List<Specialist> specialists = new ArrayList<>();

}
