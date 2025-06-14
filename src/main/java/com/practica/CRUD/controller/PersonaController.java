package com.practica.CRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practica.CRUD.model.Persona;
import com.practica.CRUD.service.PersonaService;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/buscarPersonas")
    public ResponseEntity<List<Persona>> listarPersonas(){
        return ResponseEntity.ok(personaService.listarTodas());
    }

    @PostMapping("/guardarPersona")
    public ResponseEntity<Persona> guardarPersona(@RequestBody Persona persona){
        return ResponseEntity.ok(personaService.guardar(persona));
    }

    @GetMapping("buscarPersona/{id}")
    public ResponseEntity<Persona> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(personaService.obtenerPorId(id));
    }
    
    @GetMapping("eliminarPersona/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable Long id) {
        personaService.eliminar(id);
        return ResponseEntity.ok("Persona con id: " + id.toString() + " ha sido eliminada");
    }

    @PutMapping("editarPersona")
    public ResponseEntity<Persona> editarPersona(@RequestBody Persona persona) {
        return ResponseEntity.ok(personaService.editarPersona(persona));
    }
}
