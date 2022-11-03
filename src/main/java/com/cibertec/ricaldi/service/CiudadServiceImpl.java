package com.cibertec.ricaldi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.ricaldi.entity.Ciudad;
import com.cibertec.ricaldi.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements CiudadService {

	@Autowired
	private CiudadRepository repository;
	
	@Override
	public List<Ciudad> listarTodo() {
		return repository.findAll();
	}

}
