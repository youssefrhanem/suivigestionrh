package com.rhanem.backend.repository;

import com.rhanem.backend.persistence.model.PointageBadge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointageBadgeRepository extends JpaRepository<PointageBadge, Long> {
}
