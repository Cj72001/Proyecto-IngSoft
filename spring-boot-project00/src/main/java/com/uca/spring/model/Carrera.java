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

//Verificar la generacion de los getters y setters, lombok
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
	
	@Column(name="CantidadActividadesExtracurriculares")
	Integer cantidadActividadesExtracurriculares;
	
	@Column(name="NotaAprobada")
	String notaAprobada;

	public Integer getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(Integer idCarrera) {
		this.idCarrera = idCarrera;
	}

	public Integer getUvAprobadas() {
		return uvAprobadas;
	}

	public void setUvAprobadas(Integer uvAprobadas) {
		this.uvAprobadas = uvAprobadas;
	}

	public Integer getCantidadMateriasAprobadas() {
		return cantidadMateriasAprobadas;
	}

	public void setCantidadMateriasAprobadas(Integer cantidadMateriasAprobadas) {
		this.cantidadMateriasAprobadas = cantidadMateriasAprobadas;
	}

	public String getNotaAprobada() {
		return notaAprobada;
	}

	public void setNotaAprobada(String nota) {
		this.notaAprobada = nota;
	}

	public Integer getCantidadMateriasPosibles() {
		return cantidadMateriasPosibles;
	}

	public void setCantidadMateriasPosibles(Integer cantidadMateriasPosibles) {
		this.cantidadMateriasPosibles = cantidadMateriasPosibles;
	}

	public String getMateriasPosibles() {
		return materiasPosibles;
	}

	public void setMateriasPosibles(String materiasPosibles) {
		this.materiasPosibles = materiasPosibles;
	}

	public Integer getCantidadActividadesExtracurriculares() {
		return cantidadActividadesExtracurriculares;
	}

	public void setCantidadActividadesExtracurriculares(Integer cantidadActividadesExtracurriculares) {
		this.cantidadActividadesExtracurriculares = cantidadActividadesExtracurriculares;
	}

	public String getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(String materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}
	
	
	
	
}
