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

	public String getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	public String getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(String ponderacion) {
		this.ponderacion = ponderacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}
	
}
