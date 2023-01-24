package com.densoft.carsoko.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cars")
public class Vehicle extends BaseEntity {
    @OneToOne
    private Brand brand;
    @OneToOne
    private Model model;
    @OneToOne
    private Category category;
    private int price;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_detail_id")
    private VehicleDetails vehicleDetails;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Image> images;

}
