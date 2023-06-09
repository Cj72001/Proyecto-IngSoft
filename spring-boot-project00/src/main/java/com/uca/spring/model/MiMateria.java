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

	public Integer getIdMiMateria() {
		return idMiMateria;
	}

	public void setIdMiMateria(Integer idMiMateria) {
		this.idMiMateria = idMiMateria;
	}

	public Integer getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getCatedratico() {
		return catedratico;
	}

	public void setCatedratico(String catedratico) {
		this.catedratico = catedratico;
	}

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

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	} 
	
}
