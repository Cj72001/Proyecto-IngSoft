package com.uca.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MiMateria")
@Getter
@Setter
public class MiMateria {
	
	@Id
	@Column(name="idMiMateria")
	Integer idMiMateria; 
	
	@Column(name="idEstudiante")
	Integer idEstudiante;
	
	@Column(name="Catedratico")
	String catedratico;
	
	@Column(name="Evaluacion")
	String evaluacion;
	
	@Column(name="Ponderacion")
	String ponderacion;
	
	@Column(name="FechaRealizacion")
	String fecha;
	
	@Column(name="Nota")
	String nota;
	
	@Column(name="idMateria")
	Integer idMateria;
	
	@Column(name="nombreMateria")
	String nombreMateria; 
	
}
