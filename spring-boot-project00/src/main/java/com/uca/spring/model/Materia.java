package com.uca.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Materia")
@Getter
@Setter
public class Materia {
	
	
	@Id
	@Column(name="idMateria")
	Integer idMateria; 
	
	@Column(name="NombreMateria")
	String nombreMateria;
	
	@Column(name="UV")
	Integer uv;
	
	@Column(name="Prerrequisito")
	String preRequisito;

	
}
