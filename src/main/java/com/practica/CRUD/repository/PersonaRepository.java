package com.practica.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.CRUD.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
