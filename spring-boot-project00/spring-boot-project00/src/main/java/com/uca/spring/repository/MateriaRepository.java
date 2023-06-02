package com.uca.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.spring.model.Materia;


public interface MateriaRepository extends JpaRepository<Materia, Integer>{
	
	
}