package com.densoft.carsoko.repo;

import com.densoft.carsoko.model.BusinessInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessInfoRepository extends JpaRepository<BusinessInfo, Long> {
}