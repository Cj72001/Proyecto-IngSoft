package com.uca.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.uca.spring.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer>{
	
	
}
