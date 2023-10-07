package com.example.thyml.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.thyml.dto.UserDto;
import com.example.thyml.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u "
			+ "FROM User u WHERE u.id = ?1")
	Optional<User> getUserById(Long id);
	
	
	
	
	
	
}
