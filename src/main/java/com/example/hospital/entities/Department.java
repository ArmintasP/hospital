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
@EqualsAndHashCode(of = {"name"}) @Getter @Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int floor;

    @Column(nullable = false, unique = true)
    @Size(min = 1, max = 60)
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Specialist> specialists = new ArrayList<>();

    @Version
    private int version;
}
