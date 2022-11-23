package com.uca.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.spring.model.Estudiante;
import com.uca.spring.repository.EstudianteRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository EstudianteRepository;
	
	public Estudiante createEstudiante(Estudiante cine) {
		return EstudianteRepository.save(cine);
	}
	
	public Estudiante getEstudianteById(int id) {
		return EstudianteRepository.findById(id).orElse(null);
	}
	
	public List<Estudiante> getEstudiantesById() {
		return EstudianteRepository.findAll();
	} 
	
	//Es estudiante solo puede modificar su nombre y contrasena
	public Estudiante updateEstudiante(Estudiante estudiante) {
		Estudiante oldEstudiante = null;
		java.util.Optional<Estudiante> optionalEstudiante = EstudianteRepository.findById(estudiante.getCarnetEstudiante());
		if(optionalEstudiante.isPresent()) {
			oldEstudiante = optionalEstudiante.get();
			oldEstudiante.setNombreEstudiante(estudiante.getNombreEstudiante());
			oldEstudiante.setContrasenaEstudiante(estudiante.getContrasenaEstudiante());
			EstudianteRepository.save(oldEstudiante); 
		}
		else {
			return new Estudiante();
		}
		return oldEstudiante;
	}
	
	
	public String deleteEstudianteById(int id) {
		EstudianteRepository.deleteById(id);
		return "Estudiante eliminado";
	}
}
