package com.cibertec.ricaldi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.ricaldi.entity.Cliente;
import com.cibertec.ricaldi.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> listarTodo() {
		return repository.findAll();
	}

	@Override
	public void guardar(Cliente cliente) {
		repository.save(cliente);
	}

	@Override
	public Cliente buscarPorId(int id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		repository.deleteById(id);
	}

	@Override
	public List<Cliente> buscarPorNombreYApellido(String nombre, String apellido) {
		return repository.findByNombreLikeAndApellidoLike(nombre + "%", apellido + "%");
	}

}
