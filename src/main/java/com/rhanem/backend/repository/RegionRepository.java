package com.rhanem.backend.repository;

import com.rhanem.backend.persistence.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository  extends JpaRepository<Region, Long> {
}
