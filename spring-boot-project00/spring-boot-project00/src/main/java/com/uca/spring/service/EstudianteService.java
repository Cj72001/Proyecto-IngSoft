package com.uca.spring.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.spring.model.Estudiante;
import com.uca.spring.repository.EstudianteRepository;


@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	public Estudiante createEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}
	
	public Estudiante getEstudianteById(int id) {
		return estudianteRepository.findById(id).orElse(null);
	}
	
	public List<Estudiante> getEstudiantes() {
		return estudianteRepository.findAll();
	}
	
	//Es estudiante solo puede modificar su nombre y contrasena
		public Estudiante updateEstudianteG(Estudiante oldE, Estudiante newE) {
			Estudiante oldEstudiante = null;
			java.util.Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(oldE.getIdEstudiante());
			if(optionalEstudiante.isPresent()) {
				oldEstudiante = optionalEstudiante.get();
				oldEstudiante = newE;
				estudianteRepository.save(oldEstudiante); 
			}
			else {
				return new Estudiante();
			}
			return oldEstudiante;
		}
	
	//Es estudiante solo puede modificar su nombre y contrasena
	public Estudiante updateEstudiante(Estudiante estudiante, String nuevaContrasena) {
		Estudiante oldEstudiante = null;
		java.util.Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(estudiante.getIdEstudiante());
		if(optionalEstudiante.isPresent()) {
			oldEstudiante = optionalEstudiante.get();
			oldEstudiante.setIdEstudiante(estudiante.getIdEstudiante());
			oldEstudiante.setNombreEstudiante(estudiante.getNombreEstudiante());
			oldEstudiante.setCarnetEstudiante(estudiante.getCarnetEstudiante());
			oldEstudiante.setContrasenaEstudiante(nuevaContrasena);
			estudianteRepository.save(oldEstudiante); 
		}
		else {
			return new Estudiante();
		}
		return oldEstudiante;
	}
	
	//Es estudiante solo puede modificar su nombre y contrasena
		public Estudiante updateEstudianteName(Estudiante estudiante, String nuevoName) {
			Estudiante oldEstudiante = null;
			java.util.Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(estudiante.getIdEstudiante());
			if(optionalEstudiante.isPresent()) {
				oldEstudiante = optionalEstudiante.get();
				oldEstudiante.setIdEstudiante(estudiante.getIdEstudiante());
				oldEstudiante.setNombreEstudiante(nuevoName);
				oldEstudiante.setCarnetEstudiante(estudiante.getCarnetEstudiante());
				oldEstudiante.setContrasenaEstudiante(estudiante.getContrasenaEstudiante());
				estudianteRepository.save(oldEstudiante); 
			}
			else {
				return new Estudiante();
			}
			return oldEstudiante;
		}
	
	
	
	
	public String deleteEstudianteById(int id) {
		estudianteRepository.deleteById(id);
		return "Estudiante eliminado";
	}
}
