package com.uca.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.spring.model.Logs;
import com.uca.spring.model.Materia;
import com.uca.spring.repository.LogsRepository;

@Service
public class LogsService {
	
	@Autowired
	private LogsRepository logsRepository;
	
	public Logs createLog(Logs l) {
		return logsRepository.save(l);
	}
	
	public Logs getLogById(int id) {
		return logsRepository.findById(id).orElse(null);
	}
	
	public List<Logs> getMaterias() {
		return logsRepository.findAll();
	}
	
	
}
