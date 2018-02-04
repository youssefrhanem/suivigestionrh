package com.rhanem.backend.repository;


import com.rhanem.backend.persistence.model.TypeBadge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeBadgeRepository  extends JpaRepository<TypeBadge, Long> {
}
