package com.uca.spring.model;

public class MateriaAprobada {

	private Integer idMateria; 
	private String nombreMateria;
	private Integer uv;
	private String preRequisito;
	private String nota;
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
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}
	
	
	
}
