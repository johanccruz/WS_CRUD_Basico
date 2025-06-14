package com.practica.CRUD.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.CRUD.model.Persona;
import com.practica.CRUD.repository.PersonaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonaService {
    
    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> listarTodas(){
        return personaRepository.findAll();
    }

    public Persona guardar(Persona persona){
        return personaRepository.save(persona);
    }

    public Persona obtenerPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id){
        personaRepository.deleteById(id);
    }

    public Persona editarPersona(Persona persona){
        return personaRepository.findById(persona.getId())
        .map(personaExistente -> {
            personaExistente.setNombre(persona.getNombre());
            personaExistente.setApellido(persona.getApellido());
            personaExistente.setEmail(persona.getEmail());
            personaExistente.setTelefono(persona.getTelefono());
            personaExistente.setDireccion(persona.getDireccion());
            return personaRepository.save(personaExistente);
        }).orElseThrow(() -> new EntityNotFoundException("Persona no encontrada con id " + persona.getId()));
    }
}
