package com.rhanem.backend.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.rhanem.backend.persistence.model.User;

public interface IUserJpaDAO extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByName(final String name);

    User findByNom(final String nom);

    User findByPrenom(final String prenom);

}
