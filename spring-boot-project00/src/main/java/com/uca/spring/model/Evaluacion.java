package com.uca.spring.model;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Evaluacion {
	
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
	
}
