/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examen1yahir.controllers;

import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uv.examen1yahir.models.Grupo;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.uv.examen1yahir.models.GrupoDTO;
import org.uv.examen1yahir.repository.GrupoRepository;

/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/api/grupo")
public class GrupoController {
    
    @Autowired
    private GrupoRepository grupoRepository;

    @GetMapping
    public ResponseEntity<Page<Grupo>> listGrupos(Pageable pageable) {
        return ResponseEntity.ok(grupoRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Grupo> saveGrupo(@RequestBody GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo();
        grupo.setClave_grupo(grupoDTO.getIdDTO());
        grupo.setNombre_grupo(grupoDTO.getNombreDTO());
        grupo.setAlumnos(grupoDTO.getAlumnosDTO());
        Grupo grupoGuardado = grupoRepository.save(grupo);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(grupoGuardado.getClave_grupo()).toUri();
        return ResponseEntity.created(ubicacion).body(grupoGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grupo> actualizarBiblioteca(@PathVariable Integer id, @RequestBody GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo();
        grupo.setClave_grupo(grupoDTO.getIdDTO());
        grupo.setNombre_grupo(grupoDTO.getNombreDTO());
        grupo.setAlumnos(grupoDTO.getAlumnosDTO());
        Optional<Grupo> grupoOptional = grupoRepository.findById(id);

        if (!grupoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        grupo.setClave_grupo(grupoOptional.get().getClave_grupo());
        grupoRepository.save(grupo);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grupo> obtenerGrupoPorId(@PathVariable Integer id) {
        Optional<Grupo> grupoOptional = grupoRepository.findById(id);

        if (!grupoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(grupoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Grupo> eliminarGrupo(@PathVariable Integer id) {
        Optional<Grupo> grupoOptional = grupoRepository.findById(id);

        if (!grupoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        grupoRepository.delete(grupoOptional.get());
        return ResponseEntity.noContent().build();
    }
}
