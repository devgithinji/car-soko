package com.densoft.carsoko.repo;

import com.densoft.carsoko.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}