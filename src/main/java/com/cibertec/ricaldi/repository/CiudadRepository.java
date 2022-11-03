package com.cibertec.ricaldi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.ricaldi.entity.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

}
