/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.examen1yahir.models;

import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author yacruz
 */
public class GrupoDTO {
    private int idDTO;
    private String nombreDTO;
    private Set<Alumno> alumnosDTO = new HashSet<>();

    public int getIdDTO() {
        return idDTO;
    }

    public void setIdDTO(int idDTO) {
        this.idDTO = idDTO;
    }

    public String getNombreDTO() {
        return nombreDTO;
    }

    public void setNombreDTO(String nombreDTO) {
        this.nombreDTO = nombreDTO;
    }

    public Set<Alumno> getAlumnosDTO() {
        return alumnosDTO;
    }

    public void setAlumnosDTO(Set<Alumno> alumnosDTO) {
        this.alumnosDTO = alumnosDTO;
    }
}
