package com.rhanem.backend.repository;

import com.rhanem.backend.persistence.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
