package com.densoft.carsoko.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "business_info")
public class BusinessInfo {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true, length = 500)
    private String businessName;
    @Column(unique = true, length = 500)
    private String slug;
    @Column(length = 500)
    private String address;
    @Column(length = 2000)
    private String description;
    @Column(length = 500)
    private String workingHours;
    @Column(length = 500)
    private String workingDays;

}
