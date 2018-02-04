package com.rhanem.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhanem.backend.persistence.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
