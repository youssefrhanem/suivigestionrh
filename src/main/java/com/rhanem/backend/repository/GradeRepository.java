package com.rhanem.backend.repository;

import com.rhanem.backend.persistence.model.Grade;
import com.rhanem.backend.persistence.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository  extends JpaRepository<Grade, Long> {
}
