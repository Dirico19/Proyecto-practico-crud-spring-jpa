package com.cibertec.ricaldi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.ricaldi.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	public List<Cliente> findByNombreLikeAndApellidoLike(String nombre, String apellido);
	
}
