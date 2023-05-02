package com.uca.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.spring.model.Materia;
import com.uca.spring.model.MiMateria;
import com.uca.spring.repository.MiMateriaRepository;

@Service
public class MiMateriaService {
	
	@Autowired
	private MiMateriaRepository miMateriaRepository;
	
	public MiMateria createMiMateria(MiMateria m) {
		return miMateriaRepository.save(m);
	}
	
	public void deleteMiMateriaById(int id) {
		miMateriaRepository.deleteById(id);
	}
	
	public MiMateria getMiMateriaById(int id) {
		return miMateriaRepository.findById(id).orElse(null);
	}
	
	public List<MiMateria> getMisMaterias() {
		return miMateriaRepository.findAll();
	} 
	
	//Es estudiante puede modificiar los campos de la materia
		public MiMateria updateMateria(MiMateria oldMiMateria, MiMateria newMiMateria) {
			MiMateria oldMateria = null;
			java.util.Optional<MiMateria> optionalMateria = miMateriaRepository.findById(0);
			if(optionalMateria.isPresent()) {
				oldMateria = optionalMateria.get();
				oldMateria = newMiMateria;
				miMateriaRepository.save(oldMateria); 
			}
			else {
				return new MiMateria();
			}
			return oldMateria;
		}
}
