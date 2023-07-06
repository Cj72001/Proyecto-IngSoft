package com.uca.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ActividadesExtra")
//Verificar la generacion de los getters y setters, lombok
@Getter
@Setter
public class ActividadesExtra {
	
	
	@Id
	@Column(name="idActividadesExtra")
	Integer idActividadesExtra; 
	
	@Column(name="Nombre")
	String nombreActividadesExtra;
	
	@Column(name="idEstudiante")
	Integer idEstudiante;

	public Integer getIdActividadesExtra() {
		return idActividadesExtra;
	}

	public void setIdActividadesExtra(Integer idActividadesExtra) {
		this.idActividadesExtra = idActividadesExtra;
	}

	public String getNombreActividadesExtra() {
		return nombreActividadesExtra;
	}

	public void setNombreActividadesExtra(String nombreActividadesExtra) {
		this.nombreActividadesExtra = nombreActividadesExtra;
	}

	public Integer getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}
	
	
	
}
