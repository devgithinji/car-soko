package com.densoft.carsoko.repo;

import com.densoft.carsoko.model.Trim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrimRepository extends JpaRepository<Trim, Long> {
}