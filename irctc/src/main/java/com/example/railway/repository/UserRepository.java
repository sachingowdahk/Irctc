package com.example.railway.repository;

import java.util.Optional;

//import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.railway.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
//	com.example.railway.model.User findByUsername(String username);
	 User findByUsername(String username);

	com.example.railway.model.User save(com.example.railway.model.User user);
}
