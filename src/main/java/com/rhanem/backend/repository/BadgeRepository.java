package com.rhanem.backend.repository;

import com.rhanem.backend.persistence.model.Badge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
}
