package com.uca.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Logs")

public class Logs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLog")
	Integer idLog;
	
	@Column(name="Fecha")
	String fecha;
	
	@Column(name="Carnet")
	String carnet;

	public Integer getIdCarrera() {
		return idLog;
	}

	public void setIdCarrera(Integer idCarrera) {
		this.idLog = idCarrera;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String cARNET2) {
		this.carnet = cARNET2;
	}
	
	
}
