package com.densoft.carsoko.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(length = 500)
    private String image;
    @Column(unique = true)
    private String phone;
    private String location;
    @OneToOne
    private BusinessInfo businessInfo;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Vehicle> vehicles;

}
