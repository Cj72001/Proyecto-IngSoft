package com.uca.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ActividadesExtra")
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
	
}
