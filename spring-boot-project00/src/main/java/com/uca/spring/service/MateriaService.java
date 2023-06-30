package com.uca.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.spring.model.Estudiante;
import com.uca.spring.model.Materia;
import com.uca.spring.repository.MateriaRepository;


@Service
public class MateriaService {

	@Autowired
	private MateriaRepository materiaRepository;
	
	public Materia createMateria(Materia materia) {
		return materiaRepository.save(materia);
	}
	
	public Materia getMateriaById(int id) {
		return materiaRepository.findById(id).orElse(null);
	}
	
	public List<Materia> getMaterias() {
		return materiaRepository.findAll();
	} 
	
	//Es estudiante puede modificiar los campos de la materia
	public Materia updateMateria(Materia materia) {
		Materia oldMateria = null;
		java.util.Optional<Materia> optionalMateria = materiaRepository.findById(materia.getIdMateria());
		if(optionalMateria.isPresent()) {
			oldMateria = optionalMateria.get();
			oldMateria.setNombreMateria(materia.getNombreMateria());
			oldMateria.setUv(materia.getUv());
			oldMateria.setPreRequisito(materia.getPreRequisito());
			materiaRepository.save(oldMateria); 
		}
		else {
			return new Materia();
		}
		return oldMateria;
	}
	
	
	public String deleteMateriaById(int id) {
		materiaRepository.deleteById(id);
		return "Materia eliminada";
	}
	
	public String getCategoriaById(int id) {
		Materia materia = getMateriaById(id);
		return materia.getCategoria();
	}
	
}