package com.uca.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Estudiante")
@Getter
@Setter
public class Estudiante {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="Carnet")
	Integer carnetEstudiante; 
	
	@Column(name="Nombre")
	String nombreEstudiante;
	
	@Column(name="Contrasena")
	String contrasenaEstudiante;
	
	@Column(name="Carrera")
	Integer carreraEstudiante;
	
	@Column(name="CicloActual")
	Integer cicloActualEstudiante; 
	
}
