package com.uca.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Materia")

//Verificar la generacion de los getters y setters, lombok
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
	
	@Column(name="Categoria")
	String categoria;

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

	public Integer getUv() {
		return uv;
	}

	public void setUv(Integer uv) {
		this.uv = uv;
	}

	public String getPreRequisito() {
		return preRequisito;
	}

	public void setPreRequisito(String preRequisito) {
		this.preRequisito = preRequisito;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
}
