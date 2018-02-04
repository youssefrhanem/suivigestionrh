package com.rhanem.backend.persistence.service;

import com.rhanem.backend.persistence.model.User;

public interface IUserService {

    // read

    public User findByName(final String name);

    public User findById(final long id);

    public User findByNom(final String nom);

    public User findByPrenom(final String prenom);

    // write

    public User create(final User entity);

    public void update(final User entity);

}
