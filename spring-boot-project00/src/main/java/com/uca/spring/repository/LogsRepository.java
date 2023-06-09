package com.uca.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.spring.model.Logs;

public interface LogsRepository extends JpaRepository<Logs, Integer>{

}
