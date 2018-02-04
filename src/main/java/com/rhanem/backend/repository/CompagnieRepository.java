package com.rhanem.backend.repository;

import com.rhanem.backend.persistence.model.Compagnie;
import com.rhanem.backend.persistence.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompagnieRepository  extends JpaRepository<Compagnie, Long> {
}
