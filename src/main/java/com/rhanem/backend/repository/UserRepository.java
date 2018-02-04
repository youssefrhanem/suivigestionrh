package com.rhanem.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rhanem.backend.persistence.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	
	User findBynameLike(String name);
	
	List<User> findByname(String name);
	

}
