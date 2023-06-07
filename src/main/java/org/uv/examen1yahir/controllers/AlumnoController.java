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
import org.uv.examen1yahir.models.Alumno;
import org.uv.examen1yahir.repository.AlumnosRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.uv.examen1yahir.models.Grupo;
import org.uv.examen1yahir.models.AlumnoDTO;
import org.uv.examen1yahir.repository.GrupoRepository;

/**
 *
 * @author yacruz
 */
@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnosRepository alumnoRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @GetMapping
    public ResponseEntity<Page<Alumno>> listarAlumnos(Pageable pageable) {
        return ResponseEntity.ok(alumnoRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Alumno> guardarAlumno(@RequestBody AlumnoDTO alumnoDTO) {
        Alumno alumno =new Alumno();
        alumno.setClave_alumno(alumnoDTO.getClave_Alumno());
        alumno.setNombre_alumno(alumnoDTO.getNombre_alumno());
        alumno.setDireccion_alumno(alumnoDTO.getDireccion_alumno());
        alumno.setTelefono_alumno(alumnoDTO.getTelefono_alumno());
        alumno.setGrupo(alumnoDTO.getGrupo());
        Optional<Grupo> grupoOptional = grupoRepository.findById(alumno.getGrupo().getClave_grupo());

        if (!grupoOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        alumno.setGrupo(grupoOptional.get());
        Alumno alumnoGuardado = alumnoRepository.save(alumno);
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(alumnoGuardado.getClave_alumno()).toUri();

        return ResponseEntity.created(ubicacion).body(alumnoGuardado);
    }

    @PutMapping("/{clave_alumno}")
    public ResponseEntity<Alumno> actualizarAlumno(@RequestBody AlumnoDTO alumnoDTO, @PathVariable Integer clave_alumno) {
        Alumno alumno =new Alumno();
        alumno.setClave_alumno(alumnoDTO.getClave_Alumno());
        alumno.setNombre_alumno(alumnoDTO.getNombre_alumno());
        alumno.setDireccion_alumno(alumnoDTO.getDireccion_alumno());
        alumno.setTelefono_alumno(alumnoDTO.getTelefono_alumno());
        alumno.setGrupo(alumnoDTO.getGrupo());
        Optional<Alumno> bibliotecaOptional = alumnoRepository.findById(alumno.getGrupo().getClave_grupo());

        if (!bibliotecaOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        Optional<Alumno> libroOptional = alumnoRepository.findById(clave_alumno);
        if (!libroOptional.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }
        
        alumnoRepository.save(alumno);

        return ResponseEntity.noContent().build();
    }
    
    	@DeleteMapping("/{isbn}")
	public ResponseEntity<Alumno> eliminarAlumno(@PathVariable Integer isbn){
		Optional<Alumno> libroOptional = alumnoRepository.findById(isbn);
		
		if(!libroOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		alumnoRepository.delete(libroOptional.get());
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{isbn}")
	public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable Integer isbn){
		Optional<Alumno> alumnoOptional = alumnoRepository.findById(isbn);
		
		if(!alumnoOptional.isPresent()){
			return ResponseEntity.unprocessableEntity().build();
		}
		
		return ResponseEntity.ok(alumnoOptional.get());
	}
}
