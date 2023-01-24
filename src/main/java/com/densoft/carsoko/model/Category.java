package com.densoft.carsoko.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category extends BaseEntity {

    private String name;
    public Category(String name) {
        this.name = name;
    }
}
