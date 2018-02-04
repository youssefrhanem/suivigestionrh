package com.rhanem.backend.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.rhanem.backend.persistence.model.Authority;

public interface IAuthorityJpaDAO extends JpaRepository<Authority, Long>, JpaSpecificationExecutor<Authority> {

    Authority findByName(final String name);

}
