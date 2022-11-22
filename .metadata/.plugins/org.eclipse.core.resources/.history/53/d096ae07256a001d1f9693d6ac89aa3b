package com.uca.spring.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.spring.model.ActividadesExtra;
import com.uca.spring.model.Estudiante;
import com.uca.spring.repository.ActividadesExtraRepository;


@Service
public class ActividadesExtraService {

	@Autowired
	private ActividadesExtraRepository actividadesExtraRepository;
	
	public ActividadesExtra createActividadExtra(ActividadesExtra cine) {
		return actividadesExtraRepository.save(cine);
	}
	
	public ActividadesExtra getActividadExtraById(int id) {
		return actividadesExtraRepository.findById(id).orElse(null);
	}
	
	public List<ActividadesExtra> getActividades() {
		return actividadesExtraRepository.findAll();
	} 
	
	public ActividadesExtra updateActividadesExtra(ActividadesExtra actividadesExtra) {
		ActividadesExtra oldActividadExtra = null;
		java.util.Optional<ActividadesExtra> optionalActividadExtra = actividadesExtraRepository.findById(actividadesExtra.getIdActividadesExtra());
		if(optionalActividadExtra.isPresent()) {
			oldActividadExtra = optionalActividadExtra.get();
			oldActividadExtra.setNombreActividadesExtra(actividadesExtra.getNombreActividadesExtra());
			actividadesExtraRepository.save(oldActividadExtra); 
		}
		else {
			return new ActividadesExtra();
		}
		return oldActividadExtra;
	}
	
	
	public String deleteActividadExtraById(int id) {
		actividadesExtraRepository.deleteById(id);
		return "Actividad eliminada";
	}
}