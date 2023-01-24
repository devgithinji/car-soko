package com.densoft.carsoko.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "models")
public class Model {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Trim> trims = new HashSet<>();
}
