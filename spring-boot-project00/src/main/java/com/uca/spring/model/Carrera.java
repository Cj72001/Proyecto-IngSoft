package com.uca.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Carrera")
@Getter
@Setter

public class Carrera {
	
	@Id
	@Column(name="idCarrera")
	Integer idCarrera;
	
	@Column(name="UVaprobadas")
	Integer uvAprobadas;
	
	@Column(name="CantidadMateriasAprobadas")
	Integer cantidadMateriasAprobadas;
	
	@Column(name="MateriasAprobadas")
	String materiasAprobadas;
	
	@Column(name="CantidadMateriasPosibles")
	Integer cantidadMateriasPosibles;
	
	@Column(name="MateriasPosibles")
	String materiasPosibles;
	
	
	@Column(name="HorasSocialesInternas")
	Integer horasSocialesInternas;
	
	@Column(name="HorasSocialesExternas")
	Integer horasSocialesExterna;
	
	@Column(name="AnioCarrera")
	Integer anioCarrera;
	
	
}
