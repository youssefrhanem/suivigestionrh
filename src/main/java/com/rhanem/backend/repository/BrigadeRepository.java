package com.rhanem.backend.repository;

import com.rhanem.backend.persistence.model.Brigade;
import com.rhanem.backend.persistence.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrigadeRepository  extends JpaRepository<Brigade, Long> {
}
