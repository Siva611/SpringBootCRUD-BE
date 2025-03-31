package com.jsp.SpringBootCRUD_BE.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.SpringBootCRUD_BE.dto.Student;

public interface StudentRepository  extends JpaRepository<Student, String>{

	Optional<Student> findByEmail(String email);
	
	
}
