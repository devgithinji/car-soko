package com.densoft.carsoko.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "car_details")
public class VehicleDetails {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "year_of_manufacture", length = 20)
    private String yearOfManufacture;
    private String trim;
    private String color;
    private String condition;
    private String transmission;
    private String mileage;
    @Column(name = "vin_chassis_no", length = 20)
    private String vinChassisNo;
    @Column(name = "is_registered")
    private boolean isRegistered;
    @Column(name = "is_exchange_possible")
    private boolean isExchangePossible;
    private String fuel;
    @Column(name = "drive_train")
    private String driveTrain;
    @Column(name = "no_of_seats")
    private int noOfSeats;
    @Column(name = "no_of_cylinders")
    private int noOfCylinders;
    @Column(name = "engine_size")
    private String engineSize;
    @Column(name = "horse_power")
    private String horsePower;
    @Column(length = 3000)
    private String description;
    @Column(length = 3000)
    private String features;

}
