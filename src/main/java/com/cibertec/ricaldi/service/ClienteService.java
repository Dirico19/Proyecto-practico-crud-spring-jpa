package com.cibertec.ricaldi.service;

import java.util.List;

import com.cibertec.ricaldi.entity.Cliente;

public interface ClienteService {
	
	public List<Cliente> listarTodo();

	public void guardar(Cliente cliente);

	public Cliente buscarPorId(int id);

	public void eliminar(int id);
	
	public List<Cliente> buscarPorNombreYApellido(String nombre, String apellido);
	
}
