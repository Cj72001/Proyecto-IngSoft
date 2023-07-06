package com.uca.spring.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.spring.model.Carrera;
import com.uca.spring.model.Materia;
import com.uca.spring.repository.CarreraRepository;

@Service
public class CarreraService {
	
	@Autowired
	private CarreraRepository carreraRepository;
	
	public Carrera createCarrera(Carrera carrera) {
		return carreraRepository.save(carrera);
	}
	
	public Carrera getCarreraById(int Id) {
		return carreraRepository.findById(Id).orElse(null);
	}
	
	public List<Carrera> getCarreras(){
		return carreraRepository.findAll();
	}
	
	public Carrera updateCarreraG(Carrera oldCarrera, Carrera newCarrera) {
		Carrera oldC = null;
		java.util.Optional<Carrera> optionalCarrera = carreraRepository.findById(oldCarrera.getIdCarrera());
		if(optionalCarrera.isPresent()) {
			oldC = optionalCarrera.get();
			oldC = newCarrera;
			carreraRepository.save(oldC); 
		}
		else {
			return new Carrera();
		}
		return oldC;
	}
	
	public Carrera updateCarrera(Carrera carrera) {
		Carrera oldCarrera = null;
		java.util.Optional<Carrera> optionalCarrera = carreraRepository.findById(carrera.getIdCarrera());
		if(optionalCarrera.isPresent()) {
			oldCarrera = optionalCarrera.get();
			oldCarrera.setUvAprobadas(carrera.getUvAprobadas());
			oldCarrera.setCantidadMateriasAprobadas(carrera.getCantidadMateriasAprobadas());
			oldCarrera.setMateriasAprobadas(carrera.getMateriasAprobadas());
			oldCarrera.setCantidadMateriasPosibles(carrera.getCantidadMateriasPosibles());
			oldCarrera.setMateriasPosibles(carrera.getMateriasPosibles());
			oldCarrera.setCantidadActividadesExtracurriculares(carrera.getCantidadActividadesExtracurriculares());
			carreraRepository.save(oldCarrera);
		}
		else {
			return new Carrera();
		}
		return oldCarrera;
	}
	
	
	public String deleteCarreraById(int Id) {
		carreraRepository.deleteById(Id);
		return "Carrera Eliminada";
	}
	
	public String getNotasById(int id) {
		Carrera carrera = getCarreraById(id);
		return carrera.getNotaAprobada();	
		}

}
